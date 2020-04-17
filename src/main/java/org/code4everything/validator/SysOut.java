package org.code4everything.validator;

import org.code4everything.validator.validation.SysOutValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * non validation
 *
 * @author pantao
 * @since 2020/4/17
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {SysOutValidator.class})
public @interface SysOut {

    boolean error() default false;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
