package org.uva.sea.ql.parser.stringparsing.unary;

import org.junit.Test;
import org.uva.sea.ql.ast.unary.Positive;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseException;

import static org.junit.Assert.assertEquals;

public class PositiveTest extends TestParser {

    @Test
    public void shouldEvaluateToPositiveClass() throws ParseException {
        assertEquals(Positive.class, parseExpression("+1").getClass());
    }
}
