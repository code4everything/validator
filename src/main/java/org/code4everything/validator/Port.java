package org.code4everything.validator;

import cn.hutool.core.net.NetUtil;
import org.code4everything.validator.validation.PortValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * working for number {@link NetUtil#isValidPort(int)} or {@link NetUtil#isUsableLocalPort(int)}
 *
 * @author pantao
 * @since 2020/4/17
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {PortValidator.class})
public @interface Port {

    boolean localUsable() default false;

    String message() default "must be a valid port";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
