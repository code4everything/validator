package org.code4everything.validator.validation;

import cn.hutool.core.util.CharUtil;
import org.code4everything.validator.Letter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

/**
 * @author pantao
 * @since 2020/4/16
 */
public class LetterValidator implements ConstraintValidator<Letter, CharSequence> {

    private static final String CASE = "case";

    private Letter letter;

    @Override
    public void initialize(Letter constraintAnnotation) {
        this.letter = constraintAnnotation;
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.isNull(charSequence)) {
            if (!letter.nullable()) {
                ValidatorUtils.buildTemplate(constraintValidatorContext, letter.message(), CASE, " ");
                return false;
            }
            return true;
        }
        if (letter.upperCase()) {
            for (char c : charSequence.toString().toCharArray()) {
                if (!CharUtil.isLetterUpper(c)) {
                    ValidatorUtils.buildTemplate(constraintValidatorContext, letter.message(), CASE, " upper ");
                    return false;
                }
            }
        } else if (letter.lowerCase()) {
            for (char c : charSequence.toString().toCharArray()) {
                if (!CharUtil.isLetterLower(c)) {
                    ValidatorUtils.buildTemplate(constraintValidatorContext, letter.message(), CASE, " lower ");
                    return false;
                }
            }
        } else {
            for (char c : charSequence.toString().toCharArray()) {
                if (!CharUtil.isLetter(c)) {
                    ValidatorUtils.buildTemplate(constraintValidatorContext, letter.message(), CASE, " ");
                    return false;
                }
            }
        }
        return true;
    }
}
