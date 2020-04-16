package org.code4everything.validator;

import cn.hutool.core.util.CreditCodeUtil;
import org.code4everything.validator.validation.CreditCodeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 社会信用码 {@link CreditCodeUtil#isCreditCode(CharSequence)} or {@link CreditCodeUtil#isCreditCodeSimple(CharSequence)}
 *
 * @author pantao
 * @since 2020/4/16
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {CreditCodeValidator.class})
public @interface CreditCode {

    boolean simple() default false;

    String message() default "must be credit code";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
