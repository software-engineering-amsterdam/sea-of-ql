package org.uva.sea.ql.parsing.binary;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.binary.GreaterThan;
import org.uva.sea.ql.ast.expression.binary.LessThan;
import org.uva.sea.ql.ast.expression.binary.LessThanOrEqualTo;
import org.uva.sea.ql.parsing.TestParser;
import org.uva.sea.ql.parsing.exception.ParseException;

import static org.junit.Assert.assertEquals;

public class RelationalTest extends TestParser {

    @Test
    public void shouldEvaluateToRelationalClasses() throws ParseException {
        assertEquals(LessThan.class, parseExpression("a < b").getClass());
        assertEquals(LessThan.class, parseExpression("a < b + c").getClass());
        assertEquals(LessThan.class, parseExpression("a < (b * c)").getClass());
        assertEquals(LessThan.class, parseExpression("(a * b) < c").getClass());
        assertEquals(LessThanOrEqualTo.class, parseExpression("(a <= b)").getClass());
        assertEquals(GreaterThan.class, parseExpression("a + b > c").getClass());
        assertEquals(GreaterThan.class, parseExpression("a > b + c").getClass());
    }
}
