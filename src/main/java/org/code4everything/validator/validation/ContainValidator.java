package org.code4everything.validator.validation;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import org.code4everything.validator.Contain;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Map;

/**
 * @author pantao
 * @since 2020/4/16
 */
public class ContainValidator implements ConstraintValidator<Contain, CharSequence> {

    private Contain contain;

    @Override
    public void initialize(Contain constraintAnnotation) {
        this.contain = constraintAnnotation;
    }

    @Override
    public boolean isValid(CharSequence cs, ConstraintValidatorContext constraintValidatorContext) {
        String test = contain.value();
        if (contain.ignoreCase() ? StrUtil.containsIgnoreCase(cs, test) : StrUtil.contains(cs, test)) {
            return true;
        }
        Map<String, String> map = ValidatorUtils.createMap("value", contain.value(), "ignore",
                BooleanUtil.toStringTrueFalse(contain.ignoreCase()));
        ValidatorUtils.buildTemplate(constraintValidatorContext, contain.message(), map);
        return false;
    }
}
