package org.uva.sea.ql.tests.ast.expr.value.intTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.Int;

import static junit.framework.Assert.assertEquals;

public class IsEqualToTests {

    @Test
    public void twoIntsAreEqual_isEqualToReturnsTrue() {
        assertEquals(
                new Bool(true),
                new Int(10).isEqualTo(new Int(10))
        );
    }

    @Test
    public void twoIntsAreNotEqual_isEqualToReturnsFalse() {
        assertEquals(
                new Bool(false),
                new Int(1).isEqualTo(new Int(2))
        );    }

}
