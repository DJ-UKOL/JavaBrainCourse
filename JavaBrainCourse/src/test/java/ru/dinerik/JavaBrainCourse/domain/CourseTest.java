package ru.dinerik.JavaBrainCourse.domain;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    void shouldThrowException() {
        assertThrows(ConstraintViolationException.class,
                ()->new Course(1L, "Маша", "Курс по вышиванию"));
    }

}