package org.uva.sea.ql.tests.ast.expression.value.intTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.value.Bool;
import org.uva.sea.ql.ast.expression.value.Int;

import static junit.framework.Assert.assertEquals;

public class IsGreaterThanTests {

    @Test
    public void leftIsGreaterThanRight_returnsTrue() {
        assertEquals(
                new Bool(true),
                new Int(2).isGreaterThan(new Int(1))
        );
    }

    @Test
    public void leftIsLesserThanRight_returnsFalse() {
        assertEquals(
                new Bool(false),
                new Int(1).isGreaterThan(new Int(2))
        );
    }

    @Test
    public void leftAndRightAreEqual_returnsFalse() {
        assertEquals(
                new Bool(false),
                new Int(1).isGreaterThan(new Int(1))
        );
    }

}
