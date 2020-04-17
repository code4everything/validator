package org.code4everything.validator;

import cn.hutool.core.lang.Validator;
import org.code4everything.validator.validation.MacValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * working for string {@link Validator#isMac(CharSequence)}
 *
 * @author pantao
 * @since 2020/4/17
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {MacValidator.class})
public @interface Mac {

    String message() default "must be a valid mac";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
