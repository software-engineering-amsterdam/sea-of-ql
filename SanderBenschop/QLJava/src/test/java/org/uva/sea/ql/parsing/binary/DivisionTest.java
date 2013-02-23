package org.uva.sea.ql.parsing.binary;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.binary.Divide;
import org.uva.sea.ql.parsing.TestParser;
import org.uva.sea.ql.parsing.exception.ParseException;

import static junit.framework.Assert.assertEquals;

public class DivisionTest extends TestParser {

    @Test
    public void shouldEvaluateToDivideClass() throws ParseException {
        assertEquals(Divide.class, parseExpression("a / b").getClass());
        assertEquals(Divide.class, parseExpression("a / b / c").getClass());
        assertEquals(Divide.class, parseExpression("(a / b / c)").getClass());
        assertEquals(Divide.class, parseExpression("a / (b / c)").getClass());
        assertEquals(Divide.class, parseExpression("(a / b) / c").getClass());
        assertEquals(Divide.class, parseExpression("(a / b)").getClass());
        assertEquals(Divide.class, parseExpression("a * b / c").getClass());
    }
}
