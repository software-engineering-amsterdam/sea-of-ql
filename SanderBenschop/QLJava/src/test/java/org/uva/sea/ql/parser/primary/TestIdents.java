package org.uva.sea.ql.parser.primary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.primary.Ident;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseError;

public class TestIdents extends TestParser {

    @Test
    public void shouldEvaluateToIdentClass() throws ParseError {
        assertEquals(Ident.class, parseExpression("a").getClass());
        assertEquals(Ident.class, parseExpression("abc").getClass());
        assertEquals(Ident.class, parseExpression("ABC").getClass());
        assertEquals(Ident.class, parseExpression("ABCDEF").getClass());
        assertEquals(Ident.class, parseExpression("abc2323").getClass());
        assertEquals(Ident.class, parseExpression("a2bc232").getClass());
        assertEquals(Ident.class, parseExpression("a2bc232aa").getClass());
    }
}
