package org.uva.sea.ql.tests.interpreter.valueParserTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.value.Str;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.interpreter.valueParser.StrValueParser;
import org.uva.sea.ql.interpreter.valueParser.ValueParser;

import static junit.framework.Assert.assertEquals;

public class StrValueParserTests {

    private final ValueParser valueParser = new StrValueParser();

    @Test
    public void strStringIsPassed_ReturnsStrValue() {
        final String stringValue = "abcd";
        Value value = valueParser.parseValue(stringValue);

        assertEquals(Str.class, value.getClass());
        assertEquals(stringValue, ((Str) value).getValue());
    }

}
