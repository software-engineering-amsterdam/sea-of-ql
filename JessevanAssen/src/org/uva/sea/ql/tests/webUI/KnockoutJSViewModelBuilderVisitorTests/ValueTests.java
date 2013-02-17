package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.value.Bool;
import org.uva.sea.ql.ast.expression.value.Int;
import org.uva.sea.ql.ast.expression.value.Str;

import static org.junit.Assert.assertEquals;

public class ValueTests extends KnockoutJSViewModelBuilderVisitorTests {

    @Test
    public void VisitBoolValueTrue_trueIsAddedToStringBuilder() {
        new Bool(true).accept(visitor, context);
        assertEquals("true", context.getObjectHierarchy().toString());
    }

    @Test
    public void VisitBoolValueFalse_falseIsAddedToStringBuilder() {
        new Bool(false).accept(visitor, context);
        assertEquals("false", context.getObjectHierarchy().toString());
    }

    @Test
    public void VisitIntValue_ValueIsAddedToStringBuilder() {
        final int value = 12345;
        new Int(value).accept(visitor, context);
        assertEquals(Integer.toString(value), context.getObjectHierarchy().toString());
    }

    @Test
    public void VisitStringValue_ValueIsAddedToStringBuilder() {
        final String value = "abcde";
        new Str(value).accept(visitor, context);
        assertEquals(String.format("\"%s\"", value), context.getObjectHierarchy().toString());
    }
}
