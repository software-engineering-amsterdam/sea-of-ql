package org.uva.sea.ql.tests.ast.expr.value.intTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.value.Int;

import static junit.framework.Assert.assertEquals;

public class PositiveTests {

    @Test
    public void intIsPositive_valueStaysPositive() {
        assertEquals(new Int(1), new Int(1).positive());
    }

    @Test
    public void intIsNegative_valueBecomesPositive() {
        assertEquals(new Int(1), new Int(-1).positive());
    }

}
