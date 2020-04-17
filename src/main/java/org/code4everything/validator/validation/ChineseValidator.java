package org.code4everything.validator.validation;

import cn.hutool.core.lang.Validator;
import org.code4everything.validator.Chinese;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author pantao
 * @since 2020/4/17
 */
public class ChineseValidator implements ConstraintValidator<Chinese, CharSequence> {

    private Chinese chinese;

    @Override
    public void initialize(Chinese constraintAnnotation) {
        this.chinese = constraintAnnotation;
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        context.buildConstraintViolationWithTemplate(chinese.message());
        if (chinese.has()) {
            return Validator.hasChinese(value);
        }
        if (chinese.all()) {
            return Validator.isChinese(value);
        }
        return true;
    }
}
