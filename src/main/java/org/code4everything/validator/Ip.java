package org.code4everything.validator;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.net.NetUtil;
import org.code4everything.validator.validation.IpValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * working for char sequence {@link NetUtil#isInnerIP(String)} or {@link Validator#isIpv4(CharSequence)} or {@link
 * Validator#isIpv6(CharSequence)}
 *
 * @author pantao
 * @since 2020/4/17
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {IpValidator.class})
public @interface Ip {

    boolean v4() default true;

    boolean v6() default false;

    boolean innerV4() default false;

    String message() default "must be a valid {type} ip";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
