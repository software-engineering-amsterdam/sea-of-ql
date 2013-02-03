package org.uva.sea.ql.parser.stringparsing.primary;

import org.junit.Test;
import org.uva.sea.ql.ast.primary.ObjectLiteral;
import org.uva.sea.ql.ast.primary.Str;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseError;

import static org.junit.Assert.assertEquals;

public class StringTest extends TestParser {

    @Test
    public void shouldEvaluateToStringClass() throws ParseError {
        assertEquals(Str.class, parsePrimary("\"Test\"").getClass());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void shouldRemoveOuterQuotes() throws ParseError {
        assertEquals("Test", ((ObjectLiteral<String>) parsePrimary("\"Test\"")).getValue());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void shouldProperlyEscapeNonOuterQuotes() throws ParseError {
        assertEquals("\\\"Hello\\\"", ((ObjectLiteral<String>) parsePrimary("\"\\\"Hello\\\"\"")).getValue());
    }
}
