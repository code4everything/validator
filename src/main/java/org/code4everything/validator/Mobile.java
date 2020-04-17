package org.code4everything.validator;

import cn.hutool.core.lang.Validator;
import org.code4everything.validator.validation.MobileValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * working for string, only support chinese phone now {@link Validator#isMobile(CharSequence)}
 *
 * @author pantao
 * @since 2020/4/17
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {MobileValidator.class})
public @interface Mobile {

    boolean chinese() default true;

    String message() default "phone number checking error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
