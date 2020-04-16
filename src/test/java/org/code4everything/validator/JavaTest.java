package org.code4everything.validator;

import org.junit.Test;

/**
 * @author pantao
 * @since 2020/4/16
 */
public class JavaTest {

    @Test
    public void test() {
        double d = 1;
        Object o = d;
        assert o instanceof Double;
    }
}
