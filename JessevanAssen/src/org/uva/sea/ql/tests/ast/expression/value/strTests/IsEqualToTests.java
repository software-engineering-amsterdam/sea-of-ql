package org.uva.sea.ql.tests.ast.expression.value.strTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.value.Bool;
import org.uva.sea.ql.ast.expression.value.Str;

import static junit.framework.Assert.assertEquals;

public class IsEqualToTests {

    @Test
    public void twoStringsAreEqual_isEqualToReturnsTrue() {
        assertEquals(
                new Bool(true),
                new Str("abcd").isEqualTo(new Str("abcd"))
        );
    }

    @Test
    public void twoStringsAreNotEqual_isEqualToReturnsFalse() {
        assertEquals(
                new Bool(false),
                new Str("abcd").isEqualTo(new Str("efgh"))
        );    }

}
