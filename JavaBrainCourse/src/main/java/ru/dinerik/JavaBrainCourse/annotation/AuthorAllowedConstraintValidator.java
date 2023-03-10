package ru.dinerik.JavaBrainCourse.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AuthorAllowedConstraintValidator implements ConstraintValidator<AuthorAllowed, String> {

    private Set<String> authors;

    @Override
    public void initialize(AuthorAllowed constraintAnnotation) {
        authors = Stream.of(constraintAnnotation.authors())
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return authors.contains(value);
    }
}