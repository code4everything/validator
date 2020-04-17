package org.code4everything.validator.validation;

import cn.hutool.core.net.NetUtil;
import org.code4everything.validator.Port;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

/**
 * @author pantao
 * @since 2020/4/17
 */
public class PortValidator implements ConstraintValidator<Port, Number> {

    private Port port;

    @Override
    public void initialize(Port constraintAnnotation) {
        this.port = constraintAnnotation;
    }

    @Override
    public boolean isValid(Number number, ConstraintValidatorContext context) {
        context.buildConstraintViolationWithTemplate(port.message());
        if (Objects.isNull(number)) {
            return false;
        }
        if (port.localUsable()) {
            NetUtil.isUsableLocalPort(number.intValue());
        }
        return NetUtil.isValidPort(number.intValue());
    }
}
