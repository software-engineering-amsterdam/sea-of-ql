package org.uva.sea.ql.parser.stringparsing.primary;

import org.junit.Test;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseException;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IdentTest extends TestParser {

    @Test
    public void shouldEvaluateToIdentClass() throws ParseException {
        assertEquals(Ident.class, parseIdent("a").getClass());
        assertEquals(Ident.class, parseIdent("abc").getClass());
        assertEquals(Ident.class, parseIdent("ABC").getClass());
        assertEquals(Ident.class, parseIdent("ABCDEF").getClass());
        assertEquals(Ident.class, parseIdent("abc2323").getClass());
        assertEquals(Ident.class, parseIdent("a2bc232").getClass());
        assertEquals(Ident.class, parseIdent("a2bc232aa").getClass());
    }

    @Test
    public void shouldHaveHashCodeAndEquals() {
        SourceCodeInformation sourceInfo = new SourceCodeInformation(0,0);
        Ident ident1 = new Ident("a", sourceInfo), ident2 = new Ident("a", sourceInfo);
        assertTrue(ident1.equals(ident2));
        assertEquals(ident1.hashCode(), ident2.hashCode());
    }

    @Test
    public void shouldNotHaveSameHasCodeAndNotEquals() {
        SourceCodeInformation sourceInfo = new SourceCodeInformation(0,0);
        Ident ident1 = new Ident("a", sourceInfo), ident2 = new Ident("b", sourceInfo);
        assertFalse(ident1.equals(ident2));
        assertFalse(ident1.hashCode() == ident2.hashCode());
    }
}
