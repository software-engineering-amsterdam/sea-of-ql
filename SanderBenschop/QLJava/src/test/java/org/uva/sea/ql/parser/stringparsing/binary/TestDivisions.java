package org.uva.sea.ql.parser.stringparsing.binary;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.binary.Divide;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseError;

public class TestDivisions extends TestParser {

    @Test
    public void shouldEvaluateToDivideClass() throws ParseError {
        assertEquals(Divide.class, parseExpression("a / b").getClass());
        assertEquals(Divide.class, parseExpression("a / b / c").getClass());
        assertEquals(Divide.class, parseExpression("(a / b / c)").getClass());
        assertEquals(Divide.class, parseExpression("a / (b / c)").getClass());
        assertEquals(Divide.class, parseExpression("(a / b) / c").getClass());
        assertEquals(Divide.class, parseExpression("(a / b)").getClass());
        assertEquals(Divide.class, parseExpression("a * b / c").getClass());
    }
}
