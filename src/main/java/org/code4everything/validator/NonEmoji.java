package org.code4everything.validator;

import cn.hutool.core.util.CharUtil;
import org.code4everything.validator.validation.NonEmojiValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * working for char sequence {@link CharUtil#isEmoji(char)}
 *
 * @author pantao
 * @since 2020/4/16
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {NonEmojiValidator.class})
public @interface NonEmoji {

    String message() default "must not have emoji";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
