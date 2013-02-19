package org.uva.sea.ql.parsing.binary;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.binary.Multiply;
import org.uva.sea.ql.parsing.TestParser;
import org.uva.sea.ql.parsing.exception.ParseException;

import static org.junit.Assert.assertEquals;

public class MultiplicationTest extends TestParser {

    @Test
    public void shouldEvaluateToMultiplyClass() throws ParseException {
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
