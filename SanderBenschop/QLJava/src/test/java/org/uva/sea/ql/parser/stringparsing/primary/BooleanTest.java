package org.uva.sea.ql.parser.stringparsing.primary;

import org.junit.Test;
import org.uva.sea.ql.ast.primary.Bool;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseException;

import static org.junit.Assert.assertEquals;

public class BooleanTest extends TestParser {

    @Test
    public void shouldEvaluateToBoolClass() throws ParseException {
        assertEquals(Bool.class, parsePrimary("true").getClass());
        assertEquals(Bool.class, parsePrimary("false").getClass());
    }
}
