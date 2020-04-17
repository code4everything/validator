package org.code4everything.validator;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.Month;
import cn.hutool.core.date.Quarter;
import cn.hutool.core.date.Week;
import org.code4everything.validator.validation.DateCheckerValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author pantao
 * @since 2020/4/17
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {DateCheckerValidator.class})
public @interface DateChecker {

    long min() default -1;

    long max() default -1;

    Week[] weeks() default {};

    Month[] months() default {};

    Quarter[] quarters() default {};

    boolean am() default false;

    boolean pm() default false;

    boolean leapYear() default false;

    int[] daysOfMonth() default {};

    int[] weeksOfMonth() default {};

    int[] weeksOfYear() default {};

    int[] hours() default {};

    int[] minutes() default {};

    int[] seconds() default {};

    boolean thisYear() default false;

    boolean thisMonth() default false;

    boolean thisWeek() default false;

    boolean thisDay() default false;

    Limit limit() default @Limit(lowerOffset = -1, upperOffset = -1);

    String message() default "date checking error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @interface Limit {

        /**
         * relative now, begin of day
         */
        int lowerOffset();

        /**
         * relative now, end of day
         */
        int upperOffset();

        DateField field() default DateField.DAY_OF_YEAR;
    }
}
