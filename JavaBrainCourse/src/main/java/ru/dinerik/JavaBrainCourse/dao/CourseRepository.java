package ru.dinerik.JavaBrainCourse.dao;

import org.springframework.stereotype.Repository;
import ru.dinerik.JavaBrainCourse.domain.Course;
import ru.dinerik.JavaBrainCourse.domain.util.NoCourseFoundException;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository {

    List<Course> findAll();
    Optional<Course> findById(Long id);
    void save(Course course);
    void deleteById(Long id) throws NoCourseFoundException;
    List<Course> findByTitleWithPrefix(String prefix);
}
