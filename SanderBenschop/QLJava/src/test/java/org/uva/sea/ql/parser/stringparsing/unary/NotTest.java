package org.uva.sea.ql.parser.stringparsing.unary;

import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.unary.Not;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseError;

import static org.junit.Assert.assertEquals;

public class NotTest extends TestParser {

    @Test
    public void shouldEvaluateToNotClass() throws ParseError {
        assertEquals(Not.class, parseExpression("!5").getClass());
    }
}
