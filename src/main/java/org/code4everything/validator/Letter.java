package org.code4everything.validator;

import cn.hutool.core.util.CharUtil;
import org.code4everything.validator.validation.LetterValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * working for char sequence {@link CharUtil#isLetter(char)} or {@link CharUtil#isLetterLower(char)} or {@link
 * CharUtil#isLetterUpper(char)}
 *
 * @author pantao
 * @since 2020/4/16
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {LetterValidator.class})
public @interface Letter {

    boolean lowerCase() default false;

    boolean upperCase() default false;

    boolean nullable() default false;

    String message() default "must be{case}letter";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
