package org.uva.sea.ql.tests.ast.expression.value.boolTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.value.Bool;

import static junit.framework.Assert.assertEquals;

public class IsNotEqualToTests {

    @Test
    public void twoBoolsAreEqual_isNotEqualToReturnsFalse() {
        assertEquals(
                new Bool(false),
                new Bool(true).isNotEqualTo(new Bool(true))
        );
    }

    @Test
    public void twoBoolsAreNotEqual_isNotEqualToReturnsTrue() {
        assertEquals(
                new Bool(true),
                new Bool(true).isNotEqualTo(new Bool(false))
        );
    }

}
