package org.uva.sea.ql.tests.ast.expr.value.intTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.Int;

import static junit.framework.Assert.assertEquals;

public class IsGreaterThanOrEqualToTests {

    @Test
    public void leftIsGreaterThanRight_returnsTrue() {
        assertEquals(
                new Bool(true),
                new Int(2).isGreaterThanOrEqualTo(new Int(1))
        );
    }

    @Test
    public void leftIsSmallerThanRight_returnsFalse() {
        assertEquals(
                new Bool(false),
                new Int(1).isGreaterThanOrEqualTo(new Int(2))
        );
    }

    @Test
    public void leftAndRightAreEqual_returnsTrue() {
        assertEquals(
                new Bool(true),
                new Int(1).isGreaterThanOrEqualTo(new Int(1))
        );
    }

}
