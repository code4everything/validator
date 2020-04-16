package org.code4everything.validator.validation;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import org.code4everything.validator.StartWith;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Map;
import java.util.Objects;

/**
 * @author pantao
 * @since 2020/4/16
 */
public class StartWithValidator implements ConstraintValidator<StartWith, CharSequence> {

    private StartWith startWith;

    @Override
    public void initialize(StartWith constraintAnnotation) {
        this.startWith = constraintAnnotation;
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext context) {
        Map<String, String> map = ValidatorUtils.createMap("value", startWith.value(), "ignore",
                BooleanUtil.toStringTrueFalse(startWith.ignoreCase()));
        if (Objects.isNull(charSequence)) {
            return ValidatorUtils.handleNull(context, startWith.nullable(), startWith.message(), map);
        }
        ValidatorUtils.buildTemplate(context, startWith.message(), map);
        if (startWith.ignoreCase()) {
            return StrUtil.startWithIgnoreCase(charSequence, startWith.value());
        }
        return StrUtil.startWith(charSequence, startWith.value());
    }
}
