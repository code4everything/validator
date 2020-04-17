package org.code4everything.validator;

import org.code4everything.validator.validation.ElementFilterValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * working for list, and map, non validation
 *
 * @author pantao
 * @since 2020/4/16
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {ElementFilterValidator.class})
public @interface ElementFilter {

    /**
     * working for all objects
     */
    boolean filterNullElements() default true;

    /**
     * working for char sequence, array, list and map
     */
    boolean filterEmptyElements() default false;

    /**
     * working for char sequence
     */
    boolean filterBlankElements() default false;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
