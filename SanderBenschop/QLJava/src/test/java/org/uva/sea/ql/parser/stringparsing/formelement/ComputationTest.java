package org.uva.sea.ql.parser.stringparsing.formelement;

import org.junit.Test;
import org.uva.sea.ql.ast.formelement.Computation;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseError;

import static org.junit.Assert.assertEquals;

public class ComputationTest extends TestParser {

    @Test
    public void shouldEvaluateToComputationClass() throws ParseError {
        assertEquals(Computation.class, parseStatement("ultimateQuestion : \"What is The Answer to the Ultimate Question of Life, the Universe and Everything?\" (6 * 7)").getClass());
        assertEquals(Computation.class, parseStatement("nonWorkingHoursPerDay : \"Non-working hours per day: \" (24-8) ").getClass());
    }
}
