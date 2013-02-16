package org.uva.sea.ql.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.bool.And;
import org.uva.sea.ql.ast.bool.LT;
import org.uva.sea.ql.ast.bool.Not;
import org.uva.sea.ql.ast.bool.Or;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.literal.IntLiteral;
import org.uva.sea.ql.ast.math.Neg;
import org.uva.sea.ql.ast.math.Pos;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.test.common.BoolTestHelper;
import org.uva.sea.ql.test.common.MathTestHelper;

public class TestLogical extends TestExpressions {

    private BoolTestHelper boolTestHelper;
    private MathTestHelper mathTestHelper;

    public TestLogical() {
        super();
        this.boolTestHelper = new BoolTestHelper(parser);
        this.mathTestHelper = new MathTestHelper(parser);
    }

    @Test
    public final void testAnd() throws ParseError {
        this.boolTestHelper.setClass(And.class).testBools(
                this.boolTestHelper.setClass(LT.class));
    }

    @Test
    public final void testAndWithOr() throws ParseError {
        this.boolTestHelper.setClass(And.class).testBools(
                this.boolTestHelper.setClass(Or.class));
    }

    @Test
    public final void testOr() throws ParseError {
        this.boolTestHelper.setClass(Or.class).testBools(
                this.boolTestHelper.setClass(LT.class));
    }

    @Test
    public final void testOrWithAnd() throws ParseError {
        this.boolTestHelper.setClass(Or.class).testBools(
                this.boolTestHelper.setClass(And.class));
    }

    @Test
    public final void testComplexBooleans() throws ParseError {
        this.boolTestHelper.setClass(Or.class).testComplexBools(
                this.boolTestHelper.setClass(And.class));
        this.boolTestHelper.setClass(And.class).testComplexBools(
                this.boolTestHelper.setClass(Or.class));
        this.boolTestHelper.setClass(Or.class).testComplexBools(
                this.boolTestHelper.setClass(Or.class));
        this.boolTestHelper.setClass(And.class).testComplexBools(
                this.boolTestHelper.setClass(And.class));
    }

    @Test
    public final void testBooleanPrecedence() throws ParseError {
        this.mathTestHelper.setClass(Or.class).testMathOperations(
                this.mathTestHelper.setClass(And.class));
        this.mathTestHelper.setClass(And.class).testMathOperations(
                this.mathTestHelper.setClass(Or.class));
    }

    @Test
    public final void testNeg() throws ParseError {
        this.boolTestHelper.setClass(Neg.class).testUnary();
    }

    @Test
    public final void testPosAndNeg() throws ParseError {
        Expr e = parser.parse("-1");
        assertEquals(Neg.class, e.getClass());
        UnaryExpr u = (UnaryExpr) e;
        assertEquals(IntLiteral.class, u.getAdjacent().getClass());
        IntLiteral i = (IntLiteral) u.getAdjacent();
        assertEquals(1, i.getValue());

        e = parser.parse("+1");
        assertEquals(Pos.class, e.getClass());
        u = (UnaryExpr) e;
        assertEquals(IntLiteral.class, u.getAdjacent().getClass());
        i = (IntLiteral) u.getAdjacent();
        assertEquals(1, i.getValue());
    }

    @Test
    public final void testNot() throws ParseError {
        this.boolTestHelper.setClass(Not.class).testUnary();
    }

}
