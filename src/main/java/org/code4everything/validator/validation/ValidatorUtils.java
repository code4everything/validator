package org.code4everything.validator.validation;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;

import javax.validation.ConstraintValidatorContext;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pantao
 * @since 2020/4/16
 */
final class ValidatorUtils {

    static final String ARRAY = "array";

    private ValidatorUtils() {}

    static Map<String, String> createMap(String... kvs) {
        Map<String, String> map = new HashMap<>(2, 1);
        if (ArrayUtil.isEmpty(kvs)) {
            return map;
        }
        for (int i = 0; i < kvs.length; i += 2) {
            map.put(kvs[i], kvs[i + 1]);
        }
        return map;
    }

    static void buildTemplate(ConstraintValidatorContext context, String msg, String key, String value) {
        context.buildConstraintViolationWithTemplate(StrUtil.format(msg, createMap(key, value)));
    }

    static void buildTemplate(ConstraintValidatorContext context, String msg, Map<String, String> map) {
        context.buildConstraintViolationWithTemplate(StrUtil.format(msg, map));
    }

    static boolean handleNull(ConstraintValidatorContext context, boolean nullable, String msg, String key,
                              String value) {
        return handleNull(context, nullable, msg, createMap(key, value));
    }

    static boolean handleNull(ConstraintValidatorContext context, boolean nullable, String msg,
                              Map<String, String> map) {
        if (!nullable) {
            buildTemplate(context, msg, map);
            return false;
        }
        return true;
    }
}
