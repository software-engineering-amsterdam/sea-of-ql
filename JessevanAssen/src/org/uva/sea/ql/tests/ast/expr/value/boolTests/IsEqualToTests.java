package org.uva.sea.ql.tests.ast.expr.value.boolTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.value.Bool;

import static junit.framework.Assert.assertEquals;

public class IsEqualToTests {

    @Test
    public void twoBoolsAreEqual_isEqualToReturnsTrue() {
        assertEquals(
                new Bool(true),
                new Bool(true).isEqualTo(new Bool(true))
        );
    }

    @Test
    public void twoBoolsAreNotEqual_isEqualToReturnsFalse() {
        assertEquals(
                new Bool(false),
                new Bool(true).isEqualTo(new Bool(false))
        );
    }

}
