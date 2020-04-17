package org.code4everything.validator.validation;

import cn.hutool.core.lang.Validator;
import org.code4everything.validator.Mobile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author pantao
 * @since 2020/4/17
 */
public class MobileValidator implements ConstraintValidator<Mobile, CharSequence> {

    private Mobile mobile;

    @Override
    public void initialize(Mobile constraintAnnotation) {
        this.mobile = constraintAnnotation;
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        context.buildConstraintViolationWithTemplate(mobile.message());
        if (mobile.chinese()) {
            return Validator.isMobile(value);
        }
        return true;
    }
}
