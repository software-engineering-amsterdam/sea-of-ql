package org.uva.sea.ql.tests.ast.expr.value.boolTests;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class OrTests extends BoolTests {

    @Test
    public void bothSidesArentFalse_returnsTrue() {
        assertEquals(TRUE, TRUE.or(TRUE));
        assertEquals(TRUE, FALSE.or(TRUE));
        assertEquals(TRUE, TRUE.or(FALSE));
    }

    @Test
    public void bothSidesAreFalse_returnsFalse() {
         assertEquals(FALSE, FALSE.or(FALSE));
    }
}
