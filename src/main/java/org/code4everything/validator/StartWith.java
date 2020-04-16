package org.code4everything.validator;

import cn.hutool.core.util.StrUtil;
import org.code4everything.validator.validation.StartWithValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * working for char sequence {@link StrUtil#startWith(CharSequence, char)} or {@link
 * StrUtil#startWithIgnoreCase(CharSequence, CharSequence)}
 *
 * @author pantao
 * @since 2020/4/16
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {StartWithValidator.class})
public @interface StartWith {

    String value();

    boolean ignoreCase() default false;

    boolean nullable() default false;

    String message() default "must start with {value}(ignore case: {ignore})";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
