package org.uva.sea.ql.tests.ast.expression.value.intTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.value.Bool;
import org.uva.sea.ql.ast.expression.value.Int;

import static junit.framework.Assert.assertEquals;

public class IsLesserThanTests {

    @Test
    public void leftIsLesserThanRight_returnsTrue() {
        assertEquals(
                new Bool(true),
                new Int(1).isLesserThan(new Int(2))
        );
    }

    @Test
    public void leftIsGreaterThanRight_returnsFalse() {
        assertEquals(
                new Bool(false),
                new Int(2).isLesserThan(new Int(1))
        );
    }

    @Test
    public void leftAndRightAreEqual_returnsFalse() {
        assertEquals(
                new Bool(false),
                new Int(1).isLesserThan(new Int(1))
        );
    }

}
