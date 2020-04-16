package org.code4everything.validator;

import cn.hutool.core.util.IdcardUtil;
import org.code4everything.validator.validation.IdCardValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 身份证号 {@link IdcardUtil#isValidCard(String)}
 *
 * @author pantao
 * @since 2020/4/16
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {IdCardValidator.class})
public @interface IdCard {

    String message() default "must be id card";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
