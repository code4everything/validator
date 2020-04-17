package org.code4everything.validator;

import org.code4everything.validator.validation.ZipCodeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * working for string, only support chinese now
 *
 * @author pantao
 * @since 2020/4/17
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {ZipCodeValidator.class})
public @interface ZipCode {

    boolean chinese() default true;

    String message() default "must be a valid zip code";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
