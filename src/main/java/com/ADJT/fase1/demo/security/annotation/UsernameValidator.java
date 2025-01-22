package com.ADJT.fase1.demo.security.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.ADJT.fase1.demo.security.validation.UsernameExitstsConstrainValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UsernameExitstsConstrainValidator.class)
public @interface UsernameValidator {
    String message() default "Email já existe";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}