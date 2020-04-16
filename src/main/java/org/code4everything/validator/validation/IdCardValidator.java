package org.code4everything.validator.validation;

import cn.hutool.core.util.IdcardUtil;
import org.code4everything.validator.IdCard;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

/**
 * @author pantao
 * @since 2020/4/16
 */
public class IdCardValidator implements ConstraintValidator<IdCard, CharSequence> {

    private IdCard idCard;

    @Override
    public void initialize(IdCard constraintAnnotation) {
        this.idCard = constraintAnnotation;
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.buildConstraintViolationWithTemplate(idCard.message());
        return Objects.nonNull(charSequence) && IdcardUtil.isValidCard(charSequence.toString());
    }
}
