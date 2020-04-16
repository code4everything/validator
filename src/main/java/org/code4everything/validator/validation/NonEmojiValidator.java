package org.code4everything.validator.validation;

import cn.hutool.core.util.CharUtil;
import org.code4everything.validator.NonEmoji;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

/**
 * @author pantao
 * @since 2020/4/16
 */
public class NonEmojiValidator implements ConstraintValidator<NonEmoji, CharSequence> {

    private NonEmoji nonEmoji;

    @Override
    public void initialize(NonEmoji constraintAnnotation) {
        this.nonEmoji = constraintAnnotation;
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.isNull(charSequence)) {
            return true;
        }
        constraintValidatorContext.buildConstraintViolationWithTemplate(nonEmoji.message());
        for (char c : charSequence.toString().toCharArray()) {
            if (CharUtil.isEmoji(c)) {
                return false;
            }
        }
        return true;
    }
}
