package ru.dinerik.JavaBrainCourse.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

// DTO для редактирования курса
@Data
public class CourseRequestToUpdate {

    // Что будем редактировать
    @NotBlank(message = "Course author has to be filled")
    private String author;
    @NotBlank(message = "Course title has to be filled")
    private String title;

}
