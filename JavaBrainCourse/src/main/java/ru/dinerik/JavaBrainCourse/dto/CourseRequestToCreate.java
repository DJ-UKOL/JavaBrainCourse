package ru.dinerik.JavaBrainCourse.dto;

import lombok.Data;

// DTO для создания курса
@Data
public class CourseRequestToCreate {

    private String author;
    private String title;

}
