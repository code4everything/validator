package org.code4everything.validator;

import cn.hutool.core.lang.Validator;
import org.code4everything.validator.validation.GeneralStringValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * working for string {@link Validator#isGeneral(CharSequence)} or {@link Validator#isGeneralWithChinese(CharSequence)}
 *
 * @author pantao
 * @since 2020/4/17
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {GeneralStringValidator.class})
public @interface GeneralString {

    boolean withChinese() default false;

    String message() default "general string checking error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
