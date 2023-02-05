package ru.dinerik.JavaBrainCourse.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.dinerik.JavaBrainCourse.dao.CourseRepository;
import ru.dinerik.JavaBrainCourse.domain.Course;
import ru.dinerik.JavaBrainCourse.dto.CourseRequestToCreate;
import ru.dinerik.JavaBrainCourse.dto.CourseRequestToUpdate;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNullElse;

// Бизнес логика
@Service
@Data
public class CourseService {

    private final CourseRepository repository;

    // Получить список всех курсов
    public List<Course> findAll() {
        return new ArrayList<>(repository.findAll());
    }

    // Получить курс по id
    public Course findById(Long id) {
        return repository.findById(id).orElseThrow();               // NoSuchElementException
    }

    // Читает значение префикса фильтрации из параметра самого запроса
    public List<Course> getCoursesByTitlePrefix(String titlePrefix) {
        return repository.findByTitleWithPrefix(requireNonNullElse(titlePrefix, ""));       // Возвращает первый параметр, если он не null. В противном случае возвращается второй
    }

    // Добавить новый курс
    public List<Course> createCourse(CourseRequestToCreate request) {
        Course course = new Course(null, request.getTitle(), request.getAuthor());
        repository.save(course);
        return repository.findAll();
    }

    // Редактировать курс
    public List<Course> updateCourse(Long id, CourseRequestToUpdate request) {
        Course course = repository.findById(id).orElseThrow();
        course.setTitle(request.getTitle());
        course.setAuthor(request.getAuthor());
        repository.save(course);
        return repository.findAll();
    }

    // Удалить курс
    public List<Course> deleteCourse(Long id) {
        repository.deleteById(id);
        return repository.findAll();
    }
}