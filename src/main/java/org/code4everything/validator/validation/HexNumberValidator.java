package org.code4everything.validator.validation;

import cn.hutool.core.util.HexUtil;
import org.code4everything.validator.HexNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

/**
 * @author pantao
 * @since 2020/4/16
 */
public class HexNumberValidator implements ConstraintValidator<HexNumber, CharSequence> {

    private HexNumber hexNumber;

    @Override
    public void initialize(HexNumber constraintAnnotation) {
        this.hexNumber = constraintAnnotation;
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.buildConstraintViolationWithTemplate(hexNumber.message());
        return Objects.nonNull(charSequence) && HexUtil.isHexNumber(charSequence.toString());
    }
}
