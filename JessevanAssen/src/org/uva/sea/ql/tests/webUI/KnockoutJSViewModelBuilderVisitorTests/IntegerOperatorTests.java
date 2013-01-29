package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.value.Int;

import static org.junit.Assert.assertEquals;

public class IntegerOperatorTests extends OperatorTests {
    private static final int LEFT_VALUE = 1;
    private static final Int LEFT = new Int(LEFT_VALUE);
    private static final int RIGHT_VALUE = 2;
    private static final Int RIGHT = new Int(RIGHT_VALUE);

    private static final String UNARY_PATTERN  = "(%s%s)";

    @Override protected Object getLeftValue() { return LEFT_VALUE; }
    @Override protected Object getRightValue() { return RIGHT_VALUE; }

    @Test
    public void testAdd() {
        testBinaryOperator(new Add(LEFT, RIGHT), "+");
    }

    @Test
    public void testDiv() {
        testBinaryOperator(new Div(LEFT, RIGHT), "/");
    }

    @Test
    public void testGEq() {
        testBinaryOperator(new GEq(LEFT, RIGHT), ">=");
    }

    @Test
    public void testGT() {
        testBinaryOperator(new GT(LEFT, RIGHT), ">");
    }

    @Test
    public void testLEq() {
        testBinaryOperator(new LEq(LEFT, RIGHT), "<=");
    }

    @Test
    public void testLT() {
        testBinaryOperator(new LT(LEFT, RIGHT), "<");
    }

    @Test
    public void testMul() {
        testBinaryOperator(new Mul(LEFT, RIGHT), "*");
    }

    @Test
    public void testSub() {
        testBinaryOperator(new Sub(LEFT, RIGHT), "-");
    }

    @Test
    public void testNeg() {
        testUnaryOperator(new Neg(LEFT), "-");
    }

    @Test
    public void testPos() {
        testUnaryOperator(new Pos(LEFT), "+");
    }
}
