package org.uva.sea.ql.parser.stringparsing.unary;

import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.unary.Negative;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseError;

import static org.junit.Assert.assertEquals;

public class TestNegative extends TestParser {

    @Test
    public void shouldEvaluateToNegativeClass() throws ParseError {
        assertEquals(Negative.class, parseExpression("-1").getClass());
    }
}