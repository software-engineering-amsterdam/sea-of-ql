package org.uva.sea.ql.parser.unary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.unary.Not;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseError;

public class TestNot extends TestParser {

    @Test
    public void shouldEvaluateToNotClass() throws ParseError {
        assertEquals(Not.class, parseExpression("!5").getClass());
    }
}
