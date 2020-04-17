package org.code4everything.validator;

import cn.hutool.core.lang.Validator;
import org.code4everything.validator.validation.PlateNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 中国车牌号 {@link Validator#isPlateNumber(CharSequence)}
 *
 * @author pantao
 * @since 2020/4/17
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {PlateNumberValidator.class})
public @interface PlateNumber {

    String message() default "must be a valid plate number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
