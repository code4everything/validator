package org.code4everything.validator.validation;

import cn.hutool.core.util.CreditCodeUtil;
import org.code4everything.validator.CreditCode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author pantao
 * @since 2020/4/16
 */
public class CreditCodeValidator implements ConstraintValidator<CreditCode, CharSequence> {

    private CreditCode creditCode;

    @Override
    public void initialize(CreditCode constraintAnnotation) {
        this.creditCode = constraintAnnotation;
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.buildConstraintViolationWithTemplate(creditCode.message());
        if (creditCode.simple()) {
            return CreditCodeUtil.isCreditCodeSimple(charSequence);
        }
        return CreditCodeUtil.isCreditCode(charSequence);
    }
}
