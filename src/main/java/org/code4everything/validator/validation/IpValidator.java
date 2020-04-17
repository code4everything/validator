package org.code4everything.validator.validation;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.net.NetUtil;
import org.code4everything.validator.Ip;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

/**
 * @author pantao
 * @since 2020/4/17
 */
public class IpValidator implements ConstraintValidator<Ip, CharSequence> {

    private Ip ip;

    @Override
    public void initialize(Ip constraintAnnotation) {
        this.ip = constraintAnnotation;
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext context) {
        if (ip.innerV4()) {
            ValidatorUtils.buildTemplate(context, ip.message(), "type", "inner");
            return Objects.nonNull(charSequence) && NetUtil.isInnerIP(charSequence.toString());
        } else if (ip.v6()) {
            ValidatorUtils.buildTemplate(context, ip.message(), "type", "v6");
            return Validator.isIpv6(charSequence);
        } else if (ip.v4()) {
            ValidatorUtils.buildTemplate(context, ip.message(), "type", "v4");
            return Validator.isIpv4(charSequence);
        }
        return true;
    }
}
