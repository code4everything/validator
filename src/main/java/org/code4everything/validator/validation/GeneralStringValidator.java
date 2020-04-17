package org.code4everything.validator.validation;

import cn.hutool.core.lang.Validator;
import org.code4everything.validator.GeneralString;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author pantao
 * @since 2020/4/17
 */
public class GeneralStringValidator implements ConstraintValidator<GeneralString, CharSequence> {

    private GeneralString generalString;

    @Override
    public void initialize(GeneralString constraintAnnotation) {
        this.generalString = constraintAnnotation;
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        context.buildConstraintViolationWithTemplate(generalString.message());
        if (generalString.withChinese()) {
            return Validator.isGeneralWithChinese(value);
        }
        return Validator.isGeneral(value);
    }
}
