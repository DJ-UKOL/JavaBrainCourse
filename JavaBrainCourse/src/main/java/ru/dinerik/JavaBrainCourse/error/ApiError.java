package ru.dinerik.JavaBrainCourse.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
// Простая структура для отправки ошибок по сети

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
    private String message;
    private OffsetDateTime dateOccurred;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> errors;

    public ApiError(String message, OffsetDateTime dateOccurred) {
        this.message = message;
        this.dateOccurred = OffsetDateTime.parse(dateOccurred.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
    }
}