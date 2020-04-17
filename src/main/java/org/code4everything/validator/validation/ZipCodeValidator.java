package org.code4everything.validator.validation;

import cn.hutool.core.lang.Validator;
import org.code4everything.validator.ZipCode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author pantao
 * @since 2020/4/17
 */
public class ZipCodeValidator implements ConstraintValidator<ZipCode, CharSequence> {

    private ZipCode zipCode;

    @Override
    public void initialize(ZipCode constraintAnnotation) {
        this.zipCode = constraintAnnotation;
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        context.buildConstraintViolationWithTemplate(zipCode.message());
        if (zipCode.chinese()) {
            Validator.isZipCode(value);
        }
        return true;
    }
}
