package org.uva.sea.ql.parsing.unary;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.unary.Positive;
import org.uva.sea.ql.parsing.TestParser;
import org.uva.sea.ql.parsing.exception.ParseException;

import static org.junit.Assert.assertEquals;

public class PositiveTest extends TestParser {

    @Test
    public void shouldEvaluateToPositiveClass() throws ParseException {
        assertEquals(Positive.class, parseExpression("+1").getClass());
    }
}
