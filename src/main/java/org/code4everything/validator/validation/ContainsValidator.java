package org.code4everything.validator.validation;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import org.code4everything.validator.Contains;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Map;

/**
 * @author pantao
 * @since 2020/4/16
 */
public class ContainsValidator implements ConstraintValidator<Contains, CharSequence> {

    private Contains contains;

    @Override
    public void initialize(Contains constraintAnnotation) {
        this.contains = constraintAnnotation;
    }

    @Override
    public boolean isValid(CharSequence cs, ConstraintValidatorContext constraintValidatorContext) {
        String test = contains.value();
        if (contains.ignoreCase() ? StrUtil.containsIgnoreCase(cs, test) : StrUtil.contains(cs, test)) {
            return true;
        }
        Map<String, String> map = ValidatorUtils.createMap("value", contains.value(), "ignore",
                BooleanUtil.toStringTrueFalse(contains.ignoreCase()));
        ValidatorUtils.buildTemplate(constraintValidatorContext, contains.message(), map);
        return false;
    }
}
