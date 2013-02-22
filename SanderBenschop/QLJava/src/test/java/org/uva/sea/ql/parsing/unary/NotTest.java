package org.uva.sea.ql.parsing.unary;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.unary.Not;
import org.uva.sea.ql.parsing.TestParser;
import org.uva.sea.ql.parsing.exception.ParseException;

import static org.junit.Assert.assertEquals;

public class NotTest extends TestParser {

    @Test
    public void shouldEvaluateToNotClass() throws ParseException {
        assertEquals(Not.class, parseExpression("!5").getClass());
    }
}
