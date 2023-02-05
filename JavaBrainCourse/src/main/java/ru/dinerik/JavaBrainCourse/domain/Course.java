package ru.dinerik.JavaBrainCourse.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.With;

@With
@Getter
@Setter
public class Course {

    private Long id;
    @NotNull(message = "Author can't be null")
    private String author;
    @NotNull(message = "Title can't be null")
    private String title;

    @JsonCreator            // С помощью конструктора передает параметры
    public Course(Long id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }
}