package org.code4everything.validator;

import org.code4everything.validator.validation.ElementCheckerValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * working for array, list
 *
 * @author pantao
 * @since 2020/4/16
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {ElementCheckerValidator.class})
public @interface ElementChecker {

    /**
     * working for all objects
     */
    boolean nonNullElement() default true;

    /**
     * working for char sequence, array, list and map
     */
    boolean nonEmptyElement() default false;

    /**
     * working for char sequence
     */
    boolean nonBlankElement() default false;

    boolean nullable() default false;

    String message() default "has null or empty element";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
