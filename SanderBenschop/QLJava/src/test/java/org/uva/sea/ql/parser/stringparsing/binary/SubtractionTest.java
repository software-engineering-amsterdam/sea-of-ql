package org.uva.sea.ql.parser.stringparsing.binary;

import org.junit.Test;
import org.uva.sea.ql.ast.binary.Subtract;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseException;

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
