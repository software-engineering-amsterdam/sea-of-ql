package org.uva.sea.ql.parsing.primary;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.primary.Str;
import org.uva.sea.ql.parsing.TestParser;
import org.uva.sea.ql.parsing.exception.ParseException;

import static junit.framework.Assert.assertEquals;

public class StringTest extends TestParser {

    @Test
    public void shouldEvaluateToStringClass() throws ParseException {
        assertEquals(Str.class, parsePrimary("\"Test\"").getClass());
    }

    @Test
    public void shouldRemoveOuterQuotes() throws ParseException {
        assertEquals("Test", ((Str) parsePrimary("\"Test\"")).getValue());
    }

    @Test
    public void shouldProperlyEscapeNonOuterQuotes() throws ParseException {
        assertEquals("\\\"Hello\\\"", ((Str) parsePrimary("\"\\\"Hello\\\"\"")).getValue());
    }
}
