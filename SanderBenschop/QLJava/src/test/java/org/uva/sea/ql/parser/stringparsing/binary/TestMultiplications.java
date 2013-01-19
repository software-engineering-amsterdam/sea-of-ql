package org.uva.sea.ql.parser.stringparsing.binary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.binary.Multiply;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseError;

public class TestMultiplications extends TestParser {

    @Test
    public void shouldEvaluateToMultiplyClass() throws ParseError {
        assertEquals(Multiply.class, parseExpression("a * b").getClass());
        assertEquals(Multiply.class, parseExpression("a * b * c").getClass());
        assertEquals(Multiply.class, parseExpression("a * (b * c)").getClass());
        assertEquals(Multiply.class, parseExpression("(a * b) * c").getClass());
        assertEquals(Multiply.class, parseExpression("(a * b)").getClass());
        assertEquals(Multiply.class, parseExpression("(a + b) * c").getClass());
        assertEquals(Multiply.class, parseExpression("a * (b + c)").getClass());
        assertEquals(Multiply.class, parseExpression("a / b * c").getClass());
    }
}
