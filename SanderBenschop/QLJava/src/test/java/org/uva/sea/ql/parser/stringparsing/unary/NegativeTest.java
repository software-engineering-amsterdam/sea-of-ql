package org.uva.sea.ql.parser.stringparsing.unary;

import org.junit.Test;
import org.uva.sea.ql.ast.unary.Negative;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseException;

import static org.junit.Assert.assertEquals;

public class NegativeTest extends TestParser {

    @Test
    public void shouldEvaluateToNegativeClass() throws ParseException {
        assertEquals(Negative.class, parseExpression("-1").getClass());
    }
}
