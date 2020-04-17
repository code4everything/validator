package org.code4everything.validator;

import cn.hutool.core.lang.Validator;
import org.code4everything.validator.validation.ChineseValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * working for string {@link Validator#isChinese(CharSequence)} or {@link Validator#hasChinese(CharSequence)}
 *
 * @author pantao
 * @since 2020/4/17
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {ChineseValidator.class})
public @interface Chinese {

    boolean all() default true;

    boolean has() default false;

    String message() default "chinese checking error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
