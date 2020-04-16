package org.code4everything.validator;

import cn.hutool.core.util.HexUtil;
import org.code4everything.validator.validation.HexNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * working for char sequence {@link HexUtil#isHexNumber(String)}
 *
 * @author pantao
 * @since 2020/4/16
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {HexNumberValidator.class})
public @interface HexNumber {

    String message() default "must be hex";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
