package org.uva.sea.ql.tests.ast.expression.value.strTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.value.Bool;
import org.uva.sea.ql.ast.expression.value.Str;

import static junit.framework.Assert.assertEquals;

public class IsNotEqualToTests {

    @Test
    public void twoStringsAreEqual_isNotEqualToReturnsFalse() {
        assertEquals(
                new Bool(false),
                new Str("abcd").isNotEqualTo(new Str("abcd"))
        );
    }

    @Test
    public void twoStringsAreNotEqual_isNotEqualToReturnsTruee() {
        assertEquals(
                new Bool(true),
                new Str("abcd").isNotEqualTo(new Str("efgh"))
        );    }

}
