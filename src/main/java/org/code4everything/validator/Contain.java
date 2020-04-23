package org.code4everything.validator;

import org.code4everything.validator.validation.ContainValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * working for char sequence
 *
 * @author pantao
 * @since 2020/4/16
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {ContainValidator.class})
public @interface Contain {

    String value();

    boolean ignoreCase() default false;

    String message() default "must contains {value}(ignore case: {ignore})";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
