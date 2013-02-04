package org.uva.sea.ql.tests.ast.expr.value.boolTests;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class AndTests extends BoolTests {

    @Test
    public void bothSidesAreTrue_returnsTrue() {
        assertEquals(TRUE, TRUE.and(TRUE));
    }

    @Test
    public void bothSidesArentTrue_returnsFalse() {
        assertEquals(FALSE, FALSE.and(TRUE));
        assertEquals(FALSE, TRUE.and(FALSE));
        assertEquals(FALSE, FALSE.and(FALSE));
    }
}
