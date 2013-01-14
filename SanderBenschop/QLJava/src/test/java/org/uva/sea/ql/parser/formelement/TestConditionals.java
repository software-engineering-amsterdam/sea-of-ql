package org.uva.sea.ql.parser.formelement;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.formelement.Conditional;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseError;

public class TestConditionals extends TestParser {

    @Test
    public void shouldEvaluateToConditionalClass() throws ParseError {
        assertEquals(Conditional.class, parseStatement("if(1==2){}").getClass());
        assertEquals(Conditional.class, parseStatement("if(1==2){} else {}").getClass());
    }
}
