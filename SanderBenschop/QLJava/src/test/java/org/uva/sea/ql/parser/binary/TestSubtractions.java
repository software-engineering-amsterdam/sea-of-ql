package org.uva.sea.ql.parser.binary;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.binary.Subtract;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseError;

public class TestSubtractions extends TestParser {

    @Test
    public void shouldEvaluateToSubtractClass() throws ParseError {
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
