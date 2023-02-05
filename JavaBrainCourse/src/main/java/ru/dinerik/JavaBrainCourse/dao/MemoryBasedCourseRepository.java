package ru.dinerik.JavaBrainCourse.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.dinerik.JavaBrainCourse.domain.Course;
import ru.dinerik.JavaBrainCourse.domain.util.NoCourseFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

// Для простоты храним в памяти (вместо базы данных)
@Component
public class MemoryBasedCourseRepository implements CourseRepository {

    private final Map<Long, Course> courseMap = new ConcurrentHashMap<>();
    private final AtomicLong identity = new AtomicLong();

    @PostConstruct  // Вызывается сразу после внедрения зависимости (может быть только одна аннотация в классе)
    public void init() {
        save(new Course(null, "Вася", "Основы программирования на джава"));
        save(new Course(null, "Вася", "Базы данных для самых маленьких"));
        save(new Course(null, "Петя", "Скучный маркетинг"));
    }

    @Override
    public List<Course> findAll() {
        return new ArrayList<>(courseMap.values());
    }

    @Override
    public Optional<Course> findById(Long id) {
        return Optional.ofNullable(courseMap.get(id));
    }

    @Override
    public void save(Course course) {
        Course courseWithId = course;
        if(course.getId() == null) {
            courseWithId = course.withId(identity.incrementAndGet());
        }
        courseMap.put(courseWithId.getId(), courseWithId);
    }

    @Override
    public void deleteById(Long id) {
        if (courseMap.containsKey(id)){
            courseMap.remove(id);
        }
        else {
            throw new NoCourseFoundException("No course found");
        }

    }

    // Фильтрация записей по названию
    // выбирать только те курсы, название которых начинается с заданного префикса
    @Override
    public List<Course> findByTitleWithPrefix(String prefix) {
        return courseMap.values()
                .stream()
                .filter(course -> course.getTitle().startsWith(prefix))
                .collect(Collectors.toList());
    }

}
