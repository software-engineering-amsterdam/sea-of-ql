package org.uva.sea.ql.parser.stringparsing.primary;

import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.primary.Bool;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseError;

import static org.junit.Assert.assertEquals;

public class TestBooleans extends TestParser {

    @Test
    public void shouldEvaluateToBoolClass() throws ParseError {
        assertEquals(Bool.class, parsePrimary("true").getClass());
        assertEquals(Bool.class, parsePrimary("false").getClass());
    }
}
