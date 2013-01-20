package org.uva.sea.ql.parser.stringparsing.primary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.primary.Bool;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseError;

public class TestBooleans extends TestParser {

    @Test
    public void shouldEvaluateToBoolClass() throws ParseError {
        assertEquals(Bool.class, parsePrimary("true").getClass());
        assertEquals(Bool.class, parsePrimary("false").getClass());
    }
}
