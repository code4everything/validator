package org.code4everything.validator.validation;

import cn.hutool.core.lang.Validator;
import org.code4everything.validator.PlateNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author pantao
 * @since 2020/4/17
 */
public class PlateNumberValidator implements ConstraintValidator<PlateNumber, CharSequence> {

    private PlateNumber plateNumber;

    @Override
    public void initialize(PlateNumber constraintAnnotation) {
        this.plateNumber = constraintAnnotation;
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        context.buildConstraintViolationWithTemplate(plateNumber.message());
        return Validator.isPlateNumber(value);
    }
}
