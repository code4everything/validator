package org.code4everything.validator.validation;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import org.code4everything.validator.ElementFilter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * @author pantao
 * @since 2020/4/16
 */
public class ElementFilterValidator implements ConstraintValidator<ElementFilter, Object> {

    private ElementFilter elementFilter;

    @Override
    public void initialize(ElementFilter constraintAnnotation) {
        this.elementFilter = constraintAnnotation;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.isNull(o)) {
            return true;
        }
        if (o instanceof Iterable) {
            Iterator iterator = ((Iterable) o).iterator();
            while (iterator.hasNext()) {
                Object next = iterator.next();
                if (shouldFilter(next)) {
                    iterator.remove();
                }
            }
        } else if (o instanceof Map) {
            Iterator iterator = ((Map) o).entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry next = (Map.Entry) iterator.next();
                if (shouldFilter(next.getKey())) {
                    iterator.remove();
                }
            }
        }
        return true;
    }

    private boolean shouldFilter(Object test) {
        if (elementFilter.filterBlankElements()) {
            if (test instanceof CharSequence) {
                return StrUtil.isBlank((CharSequence) test);
            }
        } else if (elementFilter.filterEmptyElements()) {
            return ObjectUtil.isEmpty(test);
        } else if (elementFilter.filterNullElements()) {
            return Objects.isNull(test);
        }
        return false;
    }
}
