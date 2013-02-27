package org.uva.sea.ql.parsing.unary;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.unary.Negative;
import org.uva.sea.ql.parsing.TestParser;
import org.uva.sea.ql.parsing.exception.ParseException;

import static org.junit.Assert.assertEquals;

public class NegativeTest extends TestParser {

    @Test
    public void shouldEvaluateToNegativeClass() throws ParseException {
        assertEquals(Negative.class, parseExpression("-1").getClass());
    }
}
