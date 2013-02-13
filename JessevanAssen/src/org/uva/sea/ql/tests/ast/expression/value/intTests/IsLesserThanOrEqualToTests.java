package org.uva.sea.ql.tests.ast.expression.value.intTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.value.Bool;
import org.uva.sea.ql.ast.expression.value.Int;

import static junit.framework.Assert.assertEquals;

public class IsLesserThanOrEqualToTests {

    @Test
    public void leftIsGreaterThanRight_returnsFalse() {
        assertEquals(
                new Bool(false),
                new Int(2).isLesserThanOrEqualTo(new Int(1))
        );
    }

    @Test
    public void leftIsSmallerThanRight_returnsTrue() {
        assertEquals(
                new Bool(true),
                new Int(1).isLesserThanOrEqualTo(new Int(2))
        );
    }

    @Test
    public void leftAndRightAreEqual_returnsTrue() {
        assertEquals(
                new Bool(true),
                new Int(1).isLesserThanOrEqualTo(new Int(1))
        );
    }

}
