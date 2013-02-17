package org.uva.sea.ql.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.literals.IntLiteral;
import org.uva.sea.ql.ast.literals.StringLiteral;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.parser.ParseError;

public class TestFields extends TestExpressions {
    public TestFields(){
        super();
    }
    @Test
    public final void testIds() throws ParseError {
        final Class<?> c = Ident.class;
        testId("a", c);
        testId("aBC", c);
        testId("bBCdEF", c);
        testId("abc2303", c);
        testId("u32bcj2a", c);
    }

    private void testId(String id, Class<?> c) throws ParseError {
        final Expr e = parser.parse(id);
        assertNotNull("result was null", e);
        assertEquals(c, e.getClass());
    }

    @Test
    public final void testNums() throws ParseError {
        assertEquals(IntLiteral.class, parser.parse("0").getClass());
        assertEquals(IntLiteral.class, parser.parse("1223").getClass());
        assertEquals(IntLiteral.class, parser.parse("234234234").getClass());
    }

    @Test
    public final void testString() throws ParseError {
        for (String s : getTestStrings()) {
            this.testString(s, false);
        }
    }

    @Test
    public final void testStringValues() throws ParseError {
        for (String s : getTestStrings()) {
            this.testString(s, true);
        }

    }

    private static final String[] getTestStrings() {
        final String[] ret = { "\"a\"", "\"1223\"", "\"2342 34234\"",
                "\"aBc\"", "\"abc 2323\"", "\"a2bc232aa\"", };
        return ret;
    }

    private void testString(String in, boolean testValue) throws ParseError {
        final Expr e = parser.parse(in);
        assertEquals(StringLiteral.class, e.getClass());
        if (testValue) {
            final StringLiteral s = (StringLiteral) e;
            assertEquals(in.replace("\"", ""), s.getValue());
        }
    }

    @Test
    public final void testInlineComment() throws ParseError {
        final Expr e = parser.parse("//this is a comment\n");
        assertEquals(null, e);
    }

    @Test
    public final void testComment() throws ParseError {
        final Expr e = parser.parse("/* this is a comment /*");
        assertEquals(null, e);
    }

    @Test
    public final void testBoolean() throws ParseError {
        final Expr e = parser.parse("boolean");
        assertNotNull(e);
        assertEquals(BooleanType.class, e.getClass());
    }

    @Test
    public final void testMoney() throws ParseError {
        final Expr e = parser.parse("money");
        assertNotNull(e);
        assertEquals(Money.class, e.getClass());
    }

    @Test
    public final void testMoneyWithValue() throws ParseError {
        final Expr e = parser.parse("money(50)");
        assertNotNull(e);
        assertEquals(Money.class, e.getClass());
    }

    @Test
    public final void testMoneyWithAdd() throws ParseError {
        final Expr e = parser.parse("money(50 + 50)");
        assertNotNull(e);
        assertEquals(Money.class, e.getClass());
    }
}
