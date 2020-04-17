package org.code4everything.validator.validation;

import cn.hutool.core.date.*;
import cn.hutool.core.util.ArrayUtil;
import org.code4everything.validator.DateChecker;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * @author pantao
 * @since 2020/4/17
 */
public class DateCheckerValidator implements ConstraintValidator<DateChecker, Object> {

    private DateChecker dateChecker;

    private DateTime dateTime;

    @Override
    public void initialize(DateChecker constraintAnnotation) {
        this.dateChecker = constraintAnnotation;
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        DateTime dateTime = null;
        if (value instanceof Date) {
            dateTime = DateUtil.date((Date) value);
        } else if (value instanceof Calendar) {
            dateTime = DateUtil.date((Calendar) value);
        } else if (value instanceof TemporalAccessor) {
            dateTime = DateUtil.date((TemporalAccessor) value);
        } else if (value instanceof Number) {
            dateTime = DateUtil.date(((Number) value).longValue());
        }

        if (Objects.isNull(dateTime)) {
            return true;
        }

        this.dateTime = dateTime;

        if (!isBetween(dateChecker.min(), dateChecker.max())) {
            return false;
        }

        if (!isWeeksValid()) {
            return false;
        }

        if (!isMonthsValid()) {
            return false;
        }

        if (!isQuartersValid()) {
            return false;
        }

        if (dateChecker.am() && !dateTime.isAM()) {
            return false;
        }

        if (dateChecker.pm() && !dateTime.isPM()) {
            return false;
        }

        if (dateChecker.leapYear() && !dateTime.isLeapYear()) {
            return false;
        }

        if (!isDaysOfMonthValid()) {
            return false;
        }

        if (!isWeeksOfMonthValid()) {
            return false;
        }

        if (!isWeeksOfYearValid()) {
            return false;
        }

        if (!isHoursValid()) {
            return false;
        }

        if (!isMinutesValid()) {
            return false;
        }

        if (!isSecondsValid()) {
            return false;
        }

        DateTime now = DateUtil.date();
        if (dateChecker.thisYear() && now.year() != dateTime.year()) {
            return false;
        }
        if (dateChecker.thisMonth() && now.month() != dateTime.month()) {
            return false;
        }
        if (dateChecker.thisWeek() && !isThisWeekValid(now)) {
            return false;
        }
        if (dateChecker.thisDay() && !isThisDayValid(now)) {
            return false;
        }

        return isLimitValid(now);
    }

    private boolean isLimitValid(DateTime now) {
        DateChecker.Limit limit = dateChecker.limit();
        int lowerOffset = -limit.lowerOffset();
        int upperOffset = limit.upperOffset();
        if (lowerOffset > 0 && upperOffset < 0) {
            return true;
        }
        DateTime start = lowerOffset > 0 ? null : DateUtil.beginOfDay(DateUtil.offset(now, limit.field(), lowerOffset));
        DateTime end = upperOffset < 0 ? null : DateUtil.endOfDay(DateUtil.offset(now, limit.field(), upperOffset));
        return isBetween(start, end);
    }

    private boolean isThisDayValid(DateTime now) {
        DateTime start = DateUtil.beginOfDay(now);
        DateTime end = DateUtil.beginOfDay(now);
        return isBetween(start, end);
    }

    private boolean isThisWeekValid(DateTime now) {
        DateTime start = DateUtil.beginOfWeek(now);
        DateTime end = DateUtil.endOfWeek(now);
        return isBetween(start, end);
    }

    private boolean isSecondsValid() {
        if (ArrayUtil.isEmpty(dateChecker.seconds())) {
            return true;
        }
        int second = dateTime.second();
        for (int s : dateChecker.seconds()) {
            if (second == s) {
                return true;
            }
        }
        return false;
    }

    private boolean isMinutesValid() {
        if (ArrayUtil.isEmpty(dateChecker.minutes())) {
            return true;
        }
        int minute = dateTime.minute();
        for (int m : dateChecker.minutes()) {
            if (minute == m) {
                return true;
            }
        }
        return false;
    }

    private boolean isHoursValid() {
        if (ArrayUtil.isEmpty(dateChecker.hours())) {
            return true;
        }
        int hour = dateTime.hour(true);
        for (int h : dateChecker.hours()) {
            if (hour == h) {
                return true;
            }
        }
        return false;
    }

    private boolean isWeeksOfYearValid() {
        if (ArrayUtil.isEmpty(dateChecker.weeksOfYear())) {
            return true;
        }
        int week = dateTime.weekOfYear();
        for (int w : dateChecker.weeksOfYear()) {
            if (week == w) {
                return true;
            }
        }
        return false;
    }

    private boolean isWeeksOfMonthValid() {
        if (ArrayUtil.isEmpty(dateChecker.weeksOfMonth())) {
            return true;
        }
        int week = dateTime.weekOfMonth();
        for (int w : dateChecker.weeksOfMonth()) {
            if (week == w) {
                return true;
            }
        }
        return false;
    }

    private boolean isDaysOfMonthValid() {
        if (ArrayUtil.isEmpty(dateChecker.daysOfMonth())) {
            return true;
        }
        int day = dateTime.dayOfMonth();
        for (int d : dateChecker.daysOfMonth()) {
            if (day == d) {
                return true;
            }
        }
        return false;
    }

    private boolean isQuartersValid() {
        if (ArrayUtil.isEmpty(dateChecker.quarters())) {
            return true;
        }
        Quarter quarter = dateTime.quarterEnum();
        for (Quarter q : dateChecker.quarters()) {
            if (quarter.equals(q)) {
                return true;
            }
        }
        return false;
    }

    private boolean isMonthsValid() {
        if (ArrayUtil.isEmpty(dateChecker.months())) {
            return true;
        }
        Month month = dateTime.monthEnum();
        for (Month m : dateChecker.months()) {
            if (month.equals(m)) {
                return true;
            }
        }
        return false;
    }

    private boolean isWeeksValid() {
        if (ArrayUtil.isEmpty(dateChecker.weeks())) {
            return true;
        }
        Week week = dateTime.dayOfWeekEnum();
        for (Week w : dateChecker.weeks()) {
            if (week.equals(w)) {
                return true;
            }
        }
        return false;
    }

    private boolean isBetween(DateTime start, DateTime end) {
        long min = Objects.isNull(start) ? -1 : start.getTime();
        long max = Objects.isNull(end) ? -1 : end.getTime();
        return isBetween(min, max);
    }

    private boolean isBetween(long min, long max) {
        boolean minValid = true;
        if (min >= 0) {
            minValid = dateTime.getTime() >= min;
        }
        boolean maxValid = true;
        if (minValid && max >= 0) {
            maxValid = dateTime.getTime() <= max;
        }
        return minValid && maxValid;
    }
}
