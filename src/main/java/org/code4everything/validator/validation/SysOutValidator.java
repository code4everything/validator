package org.code4everything.validator.validation;

import cn.hutool.core.lang.Console;
import org.code4everything.validator.SysOut;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author pantao
 * @since 2020/4/17
 */
public class SysOutValidator implements ConstraintValidator<SysOut, Object> {

    private SysOut sysOut;

    @Override
    public void initialize(SysOut constraintAnnotation) {
        this.sysOut = constraintAnnotation;
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (sysOut.error()) {
            Console.error(value);
        } else {
            Console.log(value);
        }
        return true;
    }
}
