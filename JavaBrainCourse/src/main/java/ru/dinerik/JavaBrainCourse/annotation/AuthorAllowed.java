package ru.dinerik.JavaBrainCourse.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AuthorAllowedConstraintValidator.class)
public @interface AuthorAllowed {

    String[] authors();

    // 3 обязательных параметра для своей аннотации
    String message() default "Автор не допустим ${validatedValue}. Можно: {authors}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}