package org.code4everything.validator.validation;

import org.code4everything.validator.ObjectId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author pantao
 * @since 2020/4/17
 */
public class ObjectIdValidator implements ConstraintValidator<ObjectId, String> {

    private ObjectId objectId;

    @Override
    public void initialize(ObjectId constraintAnnotation) {
        this.objectId = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        context.buildConstraintViolationWithTemplate(objectId.message());
        return cn.hutool.core.lang.ObjectId.isValid(value);
    }
}
