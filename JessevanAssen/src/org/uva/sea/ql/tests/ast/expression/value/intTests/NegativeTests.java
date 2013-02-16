package org.uva.sea.ql.tests.ast.expression.value.intTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.value.Int;

import static junit.framework.Assert.assertEquals;

public class NegativeTests {

    @Test
    public void intIsPositive_valueBecomesNegative() {
        assertEquals(new Int(-1), new Int(1).negative());
    }

    @Test
    public void intIsNegative_valueRemainsNegative() {
        assertEquals(new Int(-1), new Int(-1).negative());
    }

}
