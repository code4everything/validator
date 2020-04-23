package org.code4everything.validator.validation;

import cn.hutool.core.date.DateUtil;
import org.code4everything.validator.FormattedDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

/**
 * @author pantao
 * @since 2020/4/23
 */
public class FormattedDateValidator implements ConstraintValidator<FormattedDate, CharSequence> {

    private FormattedDate formattedDate;

    @Override
    public void initialize(FormattedDate constraintAnnotation) {
        this.formattedDate = constraintAnnotation;
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext context) {
        context.buildConstraintViolationWithTemplate(formattedDate.message());
        if (Objects.isNull(charSequence)) {
            return formattedDate.nullable();
        }
        try {
            DateUtil.parse(charSequence, formattedDate.value());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
