package org.code4everything.validator;

import org.code4everything.validator.validation.ObjectIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * working for string {@link cn.hutool.core.lang.ObjectId#isValid(String)}
 *
 * @author pantao
 * @since 2020/4/17
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {ObjectIdValidator.class})
public @interface ObjectId {

    String message() default "must be a valid object id";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
