package org.code4everything.validator.validation;

import cn.hutool.core.util.ArrayUtil;
import org.code4everything.validator.NotIn;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

import static org.code4everything.validator.validation.ValidatorUtils.ARRAY;

/**
 * @author pantao
 * @since 2020/4/16
 */
public class NotInValidator implements ConstraintValidator<NotIn, Object> {

    private NotIn notIn;

    @Override
    public void initialize(NotIn constraintAnnotation) {
        this.notIn = constraintAnnotation;
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.isNull(o)) {
            return ValidatorUtils.handleNull(constraintValidatorContext, notIn.nullable(), notIn.message(), ARRAY, "");
        }
        if (ArrayUtil.isNotEmpty(notIn.strings()) && o instanceof CharSequence) {
            String test = ((CharSequence) o).toString();
            for (String string : notIn.strings()) {
                if (Objects.equals(string, test)) {
                    String value = ArrayUtil.toString(notIn.strings());
                    ValidatorUtils.buildTemplate(constraintValidatorContext, notIn.message(), ARRAY, value);
                    return false;
                }
            }
            return true;
        }
        if (ArrayUtil.isNotEmpty(notIn.doubles()) && o instanceof Double) {
            Double test = (Double) o;
            for (Double d : notIn.doubles()) {
                if (Objects.equals(d, test)) {
                    String value = ArrayUtil.toString(notIn.doubles());
                    ValidatorUtils.buildTemplate(constraintValidatorContext, notIn.message(), ARRAY, value);
                    return false;
                }
            }
            return true;
        }
        if (ArrayUtil.isNotEmpty(notIn.floats()) && o instanceof Float) {
            Float test = (Float) o;
            for (Float f : notIn.floats()) {
                if (Objects.equals(f, test)) {
                    String value = ArrayUtil.toString(notIn.floats());
                    ValidatorUtils.buildTemplate(constraintValidatorContext, notIn.message(), ARRAY, value);
                    return false;
                }
            }
            return true;
        } else if (ArrayUtil.isNotEmpty(notIn.longs()) && o instanceof Long) {
            Long test = (Long) o;
            for (Long l : notIn.longs()) {
                if (Objects.equals(l, test)) {
                    String value = ArrayUtil.toString(notIn.longs());
                    ValidatorUtils.buildTemplate(constraintValidatorContext, notIn.message(), ARRAY, value);
                    return false;
                }
            }
            return true;
        } else if (ArrayUtil.isNotEmpty(notIn.ints()) && o instanceof Integer) {
            Integer test = (Integer) o;
            for (Integer i : notIn.ints()) {
                if (Objects.equals(i, test)) {
                    String value = ArrayUtil.toString(notIn.ints());
                    ValidatorUtils.buildTemplate(constraintValidatorContext, notIn.message(), ARRAY, value);
                    return false;
                }
            }
            return true;
        }
        if (ArrayUtil.isNotEmpty(notIn.shorts()) && o instanceof Short) {
            Short test = (Short) o;
            for (Short s : notIn.shorts()) {
                if (Objects.equals(s, test)) {
                    String value = ArrayUtil.toString(notIn.shorts());
                    ValidatorUtils.buildTemplate(constraintValidatorContext, notIn.message(), ARRAY, value);
                    return false;
                }
            }
            return true;
        }
        if (ArrayUtil.isNotEmpty(notIn.bytes()) && o instanceof Byte) {
            Byte test = (Byte) o;
            for (Byte f : notIn.bytes()) {
                if (Objects.equals(f, test)) {
                    String value = ArrayUtil.toString(notIn.bytes());
                    ValidatorUtils.buildTemplate(constraintValidatorContext, notIn.message(), ARRAY, value);
                    return false;
                }
            }
            return true;
        }
        if (ArrayUtil.isNotEmpty(notIn.chars()) && o instanceof Character) {
            Character test = (Character) o;
            for (Character f : notIn.chars()) {
                if (Objects.equals(f, test)) {
                    String value = ArrayUtil.toString(notIn.chars());
                    ValidatorUtils.buildTemplate(constraintValidatorContext, notIn.message(), ARRAY, value);
                    return false;
                }
            }
            return true;
        }
        return true;
    }
}
