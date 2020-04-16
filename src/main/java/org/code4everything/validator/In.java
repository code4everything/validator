package org.code4everything.validator;

import org.code4everything.validator.validation.InValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author pantao
 * @since 2020/4/16
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {InValidator.class})
public @interface In {

    boolean[] booleans() default {};

    char[] chars() default {};

    byte[] bytes() default {};

    short[] shorts() default {};

    int[] ints() default {};

    long[] longs() default {};

    float[] floats() default {};

    double[] doubles() default {};

    String[] strings() default {};

    boolean nullable() default false;

    String message() default "must in {array}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
