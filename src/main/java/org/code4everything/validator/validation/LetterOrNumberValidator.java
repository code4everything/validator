package org.code4everything.validator.validation;

import cn.hutool.core.util.CharUtil;
import org.code4everything.validator.LetterOrNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

/**
 * @author pantao
 * @since 2020/4/16
 */
public class LetterOrNumberValidator implements ConstraintValidator<LetterOrNumber, CharSequence> {

    private LetterOrNumber letterOrNumber;

    @Override

    public void initialize(LetterOrNumber constraintAnnotation) {
        this.letterOrNumber = constraintAnnotation;
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.buildConstraintViolationWithTemplate(letterOrNumber.message());
        if (Objects.isNull(charSequence)) {
            return letterOrNumber.nullable();
        }
        for (char c : charSequence.toString().toCharArray()) {
            if (!CharUtil.isLetterOrNumber(c)) {
                return false;
            }
        }
        return true;
    }
}
