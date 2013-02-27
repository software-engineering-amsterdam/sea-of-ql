package org.uva.sea.ql.parsing.binary;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.binary.Subtract;
import org.uva.sea.ql.parsing.TestParser;
import org.uva.sea.ql.parsing.exception.ParseException;

import static junit.framework.Assert.assertEquals;

public class SubtractionTest extends TestParser {

    @Test
    public void shouldEvaluateToSubtractClass() throws ParseException {
        assertEquals(Subtract.class, parseExpression("a - b").getClass());
        assertEquals(Subtract.class, parseExpression("a - b - c").getClass());
        assertEquals(Subtract.class, parseExpression("(a - b - c)").getClass());
        assertEquals(Subtract.class, parseExpression("a - (b - c)").getClass());
        assertEquals(Subtract.class, parseExpression("(a - b) - c").getClass());
        assertEquals(Subtract.class, parseExpression("(a - b)").getClass());
        assertEquals(Subtract.class, parseExpression("a - b * c").getClass());
        assertEquals(Subtract.class, parseExpression("a * b - c").getClass());
        assertEquals(Subtract.class, parseExpression("a + b - c").getClass());
    }
}
