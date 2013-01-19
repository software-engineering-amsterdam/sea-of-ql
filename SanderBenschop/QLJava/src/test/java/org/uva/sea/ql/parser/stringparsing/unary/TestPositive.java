package org.uva.sea.ql.parser.stringparsing.unary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.unary.Positive;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseError;

public class TestPositive extends TestParser {

    @Test
    public void shouldEvaluateToPositiveClass() throws ParseError {
        assertEquals(Positive.class, parseExpression("+1").getClass());
    }
}
