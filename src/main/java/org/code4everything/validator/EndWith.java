package org.code4everything.validator;

import cn.hutool.core.util.StrUtil;
import org.code4everything.validator.validation.EndWithValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * working for char sequence {@link StrUtil#endWith(CharSequence, char)} or {@link
 * StrUtil#endWithIgnoreCase(CharSequence, CharSequence)}
 *
 * @author pantao
 * @since 2020/4/16
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {EndWithValidator.class})
public @interface EndWith {

    String value();

    boolean ignoreCase() default false;

    boolean nullable() default false;

    String message() default "must end with {value}(ignore case: {ignore})";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
