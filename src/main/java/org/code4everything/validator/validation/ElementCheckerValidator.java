package org.code4everything.validator.validation;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import org.code4everything.validator.ElementChecker;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

/**
 * @author pantao
 * @since 2020/4/16
 */
public class ElementCheckerValidator implements ConstraintValidator<ElementChecker, Object> {

    private ElementChecker elementChecker;

    @Override
    public void initialize(ElementChecker constraintAnnotation) {
        this.elementChecker = constraintAnnotation;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.buildConstraintViolationWithTemplate(elementChecker.message());
        if (Objects.isNull(o)) {
            return elementChecker.nullable();
        }
        if (o instanceof Iterable) {
            for (Object value : (Iterable) o) {
                if (hasInvalidElement(value)) {
                    return false;
                }
            }
        } else if (ArrayUtil.isArray(o)) {
            Object[] os = (Object[]) o;
            for (Object obj : os) {
                if (hasInvalidElement(obj)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasInvalidElement(Object test) {
        if (elementChecker.nonBlankElement()) {
            if (test instanceof CharSequence) {
                return StrUtil.isBlank((CharSequence) test);
            }
        } else if (elementChecker.nonEmptyElement()) {
            return ObjectUtil.isEmpty(test);
        } else if (elementChecker.nonNullElement()) {
            return Objects.isNull(test);
        }
        return false;
    }
}
