package org.uva.sea.ql.parsing.primary;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.primary.Int;
import org.uva.sea.ql.parsing.TestParser;
import org.uva.sea.ql.parsing.exception.ParseException;

import static org.junit.Assert.assertEquals;

public class IntTest extends TestParser {

    @Test
    public void shouldEvaluateToIntClass() throws ParseException {
        assertEquals(Int.class, parsePrimary("0").getClass());
        assertEquals(Int.class, parsePrimary("1223").getClass());
        assertEquals(Int.class, parsePrimary("234234234").getClass());
    }
}
