package org.code4everything.validator.validation;

import cn.hutool.core.lang.Validator;
import org.code4everything.validator.Mac;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author pantao
 * @since 2020/4/17
 */
public class MacValidator implements ConstraintValidator<Mac, CharSequence> {

    private Mac mac;

    @Override
    public void initialize(Mac constraintAnnotation) {
        this.mac = constraintAnnotation;
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        context.buildConstraintViolationWithTemplate(mac.message());
        return Validator.isMac(value);
    }
}
