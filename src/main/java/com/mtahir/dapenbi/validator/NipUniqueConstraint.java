package com.mtahir.dapenbi.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/*
This class is Custom Anotation to validate NIP is exists or not
*/

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NipUniqueValidator.class)
public @interface NipUniqueConstraint {
    String message();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
