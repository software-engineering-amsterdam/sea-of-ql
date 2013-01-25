package org.uva.sea.ql.tests.interpreter.valueParserTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.interpreter.valueParser.BoolValueParser;
import org.uva.sea.ql.interpreter.valueParser.ValueParser;
import org.uva.sea.ql.interpreter.valueParser.ValueParserException;

import static junit.framework.Assert.assertEquals;

public class BoolValueParserTests {

    private final ValueParser valueParser = new BoolValueParser();

    @Test
    public void trueStringIsPassed_ReturnsTrueBoolValue() {
        testBoolean(true);
    }

    @Test
    public void falseStringIsPassed_ReturnsFalseBoolValue() {
        testBoolean(false);
    }


    private void testBoolean(boolean value) {
        Value parsedValue = valueParser.parseValue(Boolean.toString(value));

        assertEquals(Bool.class, parsedValue.getClass());
        assertEquals(value, ((Bool) parsedValue).getValue());
    }

    @Test(expected = ValueParserException.class)
    public void notAnBoolIsPassed_throwsException() {
        valueParser.parseValue("abcd");
    }

}
