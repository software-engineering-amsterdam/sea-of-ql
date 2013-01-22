package org.uva.sea.ql.parser.stringparsing.primary;

import org.junit.Test;
import org.uva.sea.ql.ast.primary.Int;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseError;

import static org.junit.Assert.assertEquals;

public class IntTest extends TestParser {

    @Test
    public void shouldEvaluateToIntClass() throws ParseError {
        assertEquals(Int.class, parsePrimary("0").getClass());
        assertEquals(Int.class, parsePrimary("1223").getClass());
        assertEquals(Int.class, parsePrimary("234234234").getClass());
    }
}
