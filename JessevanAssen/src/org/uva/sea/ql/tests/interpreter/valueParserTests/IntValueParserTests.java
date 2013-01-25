package org.uva.sea.ql.tests.interpreter.valueParserTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.value.*;
import org.uva.sea.ql.interpreter.valueParser.*;

import static junit.framework.Assert.assertEquals;

public class IntValueParserTests {

    private final ValueParser valueParser = new IntValueParser();

    @Test
    public void intStringIsPassed_ReturnsIntValue() {
        final int intValue = 1;
        Value value = valueParser.parseValue(Integer.toString(intValue));

        assertEquals(Int.class, value.getClass());
        assertEquals(intValue, ((Int) value).getValue());
    }

    @Test(expected = ValueParserException.class)
    public void notAnIntIsPassed_throwsException() {
        valueParser.parseValue("abcd");
    }

}
