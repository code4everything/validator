package org.code4everything.validator;

import cn.hutool.core.util.CharUtil;
import org.code4everything.validator.validation.LetterOrNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * working for char sequence {@link CharUtil#isLetterOrNumber(char)}
 *
 * @author pantao
 * @since 2020/4/16
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {LetterOrNumberValidator.class})
public @interface LetterOrNumber {

    boolean nullable() default false;

    String message() default "must be letter or number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
