package org.uva.sea.ql.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.literals.IntLiteral;
import org.uva.sea.ql.ast.literals.StringLiteral;
import org.uva.sea.ql.parser.ParseError;

public class TestLiterals extends TestExpressions {
    public TestLiterals() {

    }

    @Test
    public final void testStringLiteral() throws ParseError {
        final Expr e = parser.parse("\"blabla\"");
        assertNotNull(e);
        assertEquals(StringLiteral.class, e.getClass());
    }

    @Test
    public final void testIntLiteral() throws ParseError {
        final Expr e = parser.parse("1232");
        assertNotNull(e);
        assertEquals(IntLiteral.class, e.getClass());
    }
}
