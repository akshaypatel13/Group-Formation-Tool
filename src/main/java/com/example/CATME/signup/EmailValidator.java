package com.example.CATME.signup;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE, ANNOTATION_TYPE })
@Documented
@Constraint(validatedBy = EmailValidatorImpl.class)
@Retention(RUNTIME)
public @interface EmailValidator {

	String message() default "Email already exists!!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
