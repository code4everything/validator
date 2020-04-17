package org.code4everything.validator.validation;

import cn.hutool.core.lang.Validator;
import org.code4everything.validator.UUID;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author pantao
 * @since 2020/4/17
 */
public class UUIDValidator implements ConstraintValidator<UUID, CharSequence> {

    private UUID uuid;

    @Override
    public void initialize(UUID constraintAnnotation) {
        this.uuid = constraintAnnotation;
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        context.buildConstraintViolationWithTemplate(uuid.message());
        return Validator.isUUID(value);
    }
}
