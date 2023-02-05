package ru.dinerik.JavaBrainCourse.domain.util;

public class NoCourseFoundException extends RuntimeException {
    public NoCourseFoundException(String errorMessage) {
        super(errorMessage);
    }
}