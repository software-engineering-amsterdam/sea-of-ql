package org.uva.sea.ql.parser.stringparsing.primary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.primary.Primary;
import org.uva.sea.ql.ast.nodetypes.primary.Str;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseError;

public class TestStrings extends TestParser {

    @Test
    public void shouldEvaluateToStringClass() throws ParseError {
        assertEquals(Str.class, parseExpression("\"Test\"").getClass());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void shouldRemoveOuterQuotes() throws ParseError {
        assertEquals("Test", ((Primary<String>) parseExpression("\"Test\"")).getValue());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void shouldProperlyEscapeNonOuterQuotes() throws ParseError {
        assertEquals("\\\"Hello\\\"", ((Primary<String>) parseExpression("\"\\\"Hello\\\"\"")).getValue());
    }
}
