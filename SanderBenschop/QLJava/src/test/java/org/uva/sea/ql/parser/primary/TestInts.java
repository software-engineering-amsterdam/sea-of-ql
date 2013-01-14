package org.uva.sea.ql.parser.primary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.primary.Int;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseError;

public class TestInts extends TestParser {

    @Test
    public void shouldEvaluateToIntClass() throws ParseError {
        assertEquals(Int.class, parseExpression("0").getClass());
        assertEquals(Int.class, parseExpression("1223").getClass());
        assertEquals(Int.class, parseExpression("234234234").getClass());
    }
}
