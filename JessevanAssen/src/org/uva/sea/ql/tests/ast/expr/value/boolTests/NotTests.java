package org.uva.sea.ql.tests.ast.expr.value.boolTests;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class NotTests extends BoolTests {

    @Test
    public void notCalledOnTrue_returnsFalse() {
        assertEquals(FALSE, TRUE.not());
    }

    @Test
    public void notCalledOnFalse_returnsTrue() {
        assertEquals(TRUE, FALSE.not());
    }

}
