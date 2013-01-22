package org.uva.sea.ql.parser.stringparsing.binary;

import org.junit.Test;
import org.uva.sea.ql.ast.binary.GreaterThan;
import org.uva.sea.ql.ast.binary.LessThan;
import org.uva.sea.ql.ast.binary.LessThanOrEqualTo;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseError;

import static org.junit.Assert.assertEquals;

public class RelationalTest extends TestParser {

    @Test
    public void shouldEvaluateToRelationalClasses() throws ParseError {
        assertEquals(LessThan.class,  parseExpression("a < b").getClass());
        assertEquals(LessThan.class,  parseExpression("a < b + c").getClass());
        assertEquals(LessThan.class,  parseExpression("a < (b * c)").getClass());
        assertEquals(LessThan.class,  parseExpression("(a * b) < c").getClass());
        assertEquals(LessThanOrEqualTo.class, parseExpression("(a <= b)").getClass());
        assertEquals(GreaterThan.class,  parseExpression("a + b > c").getClass());
        assertEquals(GreaterThan.class,  parseExpression("a > b + c").getClass());
    }
}
