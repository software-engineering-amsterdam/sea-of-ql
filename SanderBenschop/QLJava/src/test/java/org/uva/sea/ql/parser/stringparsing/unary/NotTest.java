package org.uva.sea.ql.parser.stringparsing.unary;

import org.junit.Test;
import org.uva.sea.ql.ast.unary.Not;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseException;

import static org.junit.Assert.assertEquals;

public class NotTest extends TestParser {

    @Test
    public void shouldEvaluateToNotClass() throws ParseException {
        assertEquals(Not.class, parseExpression("!5").getClass());
    }
}
