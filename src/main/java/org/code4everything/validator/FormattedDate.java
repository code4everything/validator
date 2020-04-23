package org.code4everything.validator;

import cn.hutool.core.date.DatePattern;
import org.code4everything.validator.validation.FormattedDateValidator;

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
 * @since 2020/4/23
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {FormattedDateValidator.class})
public @interface FormattedDate {

    /**
     * date format
     */
    String value() default DatePattern.NORM_DATE_PATTERN;

    boolean nullable() default false;

    String message() default "date format error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
