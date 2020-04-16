package org.code4everything.validator.validation;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ReflectUtil;
import org.code4everything.validator.Sort;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * @author pantao
 * @since 2020/4/16
 */
public class SortValidator implements ConstraintValidator<Sort, Object> {

    private Sort sort;

    @Override
    public void initialize(Sort constraintAnnotation) {
        this.sort = constraintAnnotation;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.isNull(o)) {
            return true;
        }
        if (o instanceof List) {
            Comparator<?> comparator = ReflectUtil.newInstance(sort.comparator());
            //noinspection rawtypes
            CollUtil.sort((List) o, comparator);
        }
        return true;
    }
}
