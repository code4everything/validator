package org.code4everything.validator.validation;

import cn.hutool.core.util.ArrayUtil;
import org.code4everything.validator.In;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

import static org.code4everything.validator.validation.ValidatorUtils.ARRAY;

/**
 * @author pantao
 * @since 2020/4/16
 */
public class InValidator implements ConstraintValidator<In, Object> {

    private In in;

    @Override
    public void initialize(In constraintAnnotation) {
        this.in = constraintAnnotation;
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.isNull(o)) {
            return ValidatorUtils.handleNull(constraintValidatorContext, in.nullable(), in.message(), ARRAY, "");
        }
        String value = "";
        if (ArrayUtil.isNotEmpty(in.strings())) {
            if (o instanceof CharSequence) {
                String test = ((CharSequence) o).toString();
                for (String string : in.strings()) {
                    if (Objects.equals(string, test)) {
                        return true;
                    }
                }
                value = ArrayUtil.toString(in.strings());
            }
        } else if (ArrayUtil.isNotEmpty(in.doubles())) {
            if (o instanceof Double) {
                Double test = (Double) o;
                for (Double d : in.doubles()) {
                    if (Objects.equals(d, test)) {
                        return true;
                    }
                }
                value = ArrayUtil.toString(in.doubles());
            }
        } else if (ArrayUtil.isNotEmpty(in.floats())) {
            if (o instanceof Float) {
                Float test = (Float) o;
                for (Float f : in.floats()) {
                    if (Objects.equals(f, test)) {
                        return true;
                    }
                }
                value = ArrayUtil.toString(in.floats());
            }
        } else if (ArrayUtil.isNotEmpty(in.longs())) {
            if (o instanceof Long) {
                Long test = (Long) o;
                for (Long l : in.longs()) {
                    if (Objects.equals(l, test)) {
                        return true;
                    }
                }
                value = ArrayUtil.toString(in.longs());
            }
        } else if (ArrayUtil.isNotEmpty(in.ints())) {
            if (o instanceof Integer) {
                Integer test = (Integer) o;
                for (Integer i : in.ints()) {
                    if (Objects.equals(i, test)) {
                        return true;
                    }
                }
                value = ArrayUtil.toString(in.ints());
            }
        } else if (ArrayUtil.isNotEmpty(in.shorts())) {
            if (o instanceof Short) {
                Short test = (Short) o;
                for (Short s : in.shorts()) {
                    if (Objects.equals(s, test)) {
                        return true;
                    }
                }
                value = ArrayUtil.toString(in.shorts());
            }
        } else if (ArrayUtil.isNotEmpty(in.bytes())) {
            if (o instanceof Byte) {
                Byte test = (Byte) o;
                for (Byte f : in.bytes()) {
                    if (Objects.equals(f, test)) {
                        return true;
                    }
                }
                value = ArrayUtil.toString(in.bytes());
            }
        } else if (ArrayUtil.isNotEmpty(in.chars())) {
            if (o instanceof Character) {
                Character test = (Character) o;
                for (Character f : in.chars()) {
                    if (Objects.equals(f, test)) {
                        return true;
                    }
                }
                value = ArrayUtil.toString(in.chars());
            }
        } else if (ArrayUtil.isNotEmpty(in.booleans())) {
            if (o instanceof Boolean) {
                Boolean test = (Boolean) o;
                for (Boolean b : in.booleans()) {
                    if (Objects.equals(b, test)) {
                        return true;
                    }
                }
                value = ArrayUtil.toString(in.booleans());
            }
        }
        ValidatorUtils.buildTemplate(constraintValidatorContext, in.message(), ARRAY, value);
        return false;
    }
}
