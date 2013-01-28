package org.uva.sea.ql.parser.stringparsing.primary;

import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.primary.Datatype;
import org.uva.sea.ql.ast.nodetypes.primary.Str;
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
        assertEquals("Test", ((Datatype<String>) parsePrimary("\"Test\"")).getValue());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void shouldProperlyEscapeNonOuterQuotes() throws ParseError {
        assertEquals("\\\"Hello\\\"", ((Datatype<String>) parsePrimary("\"\\\"Hello\\\"\"")).getValue());
    }
}
