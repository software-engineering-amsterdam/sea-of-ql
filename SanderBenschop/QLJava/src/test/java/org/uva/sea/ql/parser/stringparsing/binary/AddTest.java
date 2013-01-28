package org.uva.sea.ql.parser.stringparsing.binary;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.binary.Add;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseError;

public class AddTest extends TestParser {

    @Test
    public void shouldEvaluateToAddClass() throws ParseError {
        assertEquals(Add.class, parseExpression("a + b").getClass());
        assertEquals(Add.class, parseExpression("a + b + c").getClass());
        assertEquals(Add.class, parseExpression("(a + b + c)").getClass());
        assertEquals(Add.class, parseExpression("a + (b + c)").getClass());
        assertEquals(Add.class, parseExpression("(a + b) + c").getClass());
        assertEquals(Add.class, parseExpression("(a + b)").getClass());
        assertEquals(Add.class, parseExpression("a + b * c").getClass());
        assertEquals(Add.class, parseExpression("a * b + c").getClass());
        assertEquals(Add.class, parseExpression("a - b + c").getClass());
    }
}