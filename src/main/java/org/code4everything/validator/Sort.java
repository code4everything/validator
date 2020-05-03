package org.code4everything.validator;

import org.code4everything.validator.validation.SortValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Comparator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * working for list, non validation
 *
 * @author pantao
 * @since 2020/4/16
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {SortValidator.class})
public @interface Sort {

    Class<? extends Comparator<?>> comparator();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
