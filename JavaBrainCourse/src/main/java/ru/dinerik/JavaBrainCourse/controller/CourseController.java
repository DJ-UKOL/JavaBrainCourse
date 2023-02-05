package ru.dinerik.JavaBrainCourse.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dinerik.JavaBrainCourse.domain.Course;
import ru.dinerik.JavaBrainCourse.dto.CourseRequestToCreate;
import ru.dinerik.JavaBrainCourse.dto.CourseRequestToUpdate;
import ru.dinerik.JavaBrainCourse.service.CourseService;

import java.util.List;

@RestController     // JSON формат
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;

    // Получить список всех курсов
    @GetMapping("")
    public List<Course> courseTable() {
        return service.findAll();
    }

    // Получить курс по id
    @GetMapping("/{id}")
    public Course findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    // Читает значение префикса фильтрации из параметра самого запроса
    @GetMapping("/filter")
    public List<Course> getCoursesByTitlePrefix(@RequestParam(name = "titlePrefix", required = false) String titlePrefix) {
        return service.getCoursesByTitlePrefix(titlePrefix);
    }

    // Добавить новый курс
    @PostMapping
    public List<Course> createCourse(@RequestBody CourseRequestToCreate request) {
        return service.createCourse(request);
    }

    // Редактировать курс
    @PutMapping("/{id}")
    public List<Course> updateCourse(@PathVariable Long id,
                                     @Valid @RequestBody CourseRequestToUpdate request) {
        return service.updateCourse(id, request);
    }

    // Удалить курс
    @DeleteMapping("/{id}")
    public List<Course> deleteCourse(@PathVariable Long id) {
        return service.deleteCourse(id);
    }
}