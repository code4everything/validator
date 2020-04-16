package org.code4everything.validator.validation;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import org.code4everything.validator.EndWith;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Map;
import java.util.Objects;

/**
 * @author pantao
 * @since 2020/4/16
 */
public class EndWithValidator implements ConstraintValidator<EndWith, CharSequence> {

    private EndWith endWith;

    @Override
    public void initialize(EndWith constraintAnnotation) {
        this.endWith = constraintAnnotation;
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext context) {
        Map<String, String> map = ValidatorUtils.createMap("value", endWith.value(), "ignore",
                BooleanUtil.toStringTrueFalse(endWith.ignoreCase()));
        if (Objects.isNull(charSequence)) {
            return ValidatorUtils.handleNull(context, endWith.nullable(), endWith.message(), map);
        }
        ValidatorUtils.buildTemplate(context, endWith.message(), map);
        if (endWith.ignoreCase()) {
            return StrUtil.endWithIgnoreCase(charSequence, endWith.value());
        }
        return StrUtil.endWith(charSequence, endWith.value());
    }
}
