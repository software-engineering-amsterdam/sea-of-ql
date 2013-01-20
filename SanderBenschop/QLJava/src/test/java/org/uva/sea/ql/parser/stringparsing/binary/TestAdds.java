package org.uva.sea.ql.parser.stringparsing.binary;

import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.binary.Add;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseError;

import static junit.framework.Assert.assertEquals;

public class TestAdds extends TestParser {

    @Test
    public void shouldEvaluateToAddClass() throws ParseError {
        assertEquals(Add.class, parseExpression("a + b").getClass());
        assertEquals(Add.class, parseExpression("a + b + c").getClass());
        assertEquals(Add.class, parseExpression("(a + b + c)").getClass());
        assertEquals(Add.class, parseExpression("a + (b + c)").getClass());
        assertEquals(Add.class, parseExpression("(a + b) + c").getClass());
        assertEquals(Add.class, parseExpression("(a + b)").getClass());
        assertEquals(Add.class, parseExpression("a + b * c").getClass());
        assertEquals(Add.class, parseExpression("a * b + c").getClass());
        assertEquals(Add.class, parseExpression("a - b + c").getClass());
    }
}