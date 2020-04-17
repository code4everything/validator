package org.code4everything.validator;

import cn.hutool.core.lang.Validator;
import org.code4everything.validator.validation.UUIDValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * working for string {@link Validator#isUUID(CharSequence)}
 *
 * @author pantao
 * @since 2020/4/17
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {UUIDValidator.class})
public @interface UUID {

    String message() default "must be a valid uuid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
