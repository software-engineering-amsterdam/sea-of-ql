package org.uva.sea.ql.tests.ast.expr.value.strTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.Str;

import static junit.framework.Assert.assertEquals;

public class IsEqualToTests {

    @Test
    public void twoStringsAreEqual_equalsReturnsTrue() {
        assertEquals(
                new Bool(true),
                new Str("abcd").isEqualTo(new Str("abcd"))
        );
    }

    @Test
    public void twoStringsAreNotEqual_equalsReturnsFalse() {
        assertEquals(
                new Bool(false),
                new Str("abcd").isEqualTo(new Str("efgh"))
        );    }

}
