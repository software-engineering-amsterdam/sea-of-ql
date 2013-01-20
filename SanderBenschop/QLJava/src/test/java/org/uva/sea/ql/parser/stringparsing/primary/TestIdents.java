package org.uva.sea.ql.parser.stringparsing.primary;

import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.primary.Ident;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseError;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void shouldHaveHashCodeAndEquals() {
        Ident ident1 = new Ident("a"), ident2 = new Ident("a");
        assertTrue(ident1.equals(ident2));
        assertEquals(ident1.hashCode(), ident2.hashCode());
    }

    @Test
    public void shouldNotHaveSameHasCodeAndNotEquals() {
        Ident ident1 = new Ident("a"), ident2 = new Ident("b");
        assertFalse(ident1.equals(ident2));
        assertFalse(ident1.hashCode() == ident2.hashCode());
    }
}
