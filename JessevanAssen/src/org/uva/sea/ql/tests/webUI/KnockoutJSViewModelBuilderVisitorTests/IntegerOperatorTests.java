package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.value.Int;

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
        testBinaryOperator(new Divide(LEFT, RIGHT), "/");
    }

    @Test
    public void testGEq() {
        testBinaryOperator(new GreaterThanOrEqualTo(LEFT, RIGHT), ">=");
    }

    @Test
    public void testGT() {
        testBinaryOperator(new GreaterThan(LEFT, RIGHT), ">");
    }

    @Test
    public void testLEq() {
        testBinaryOperator(new LesserThanOrEqualTo(LEFT, RIGHT), "<=");
    }

    @Test
    public void testLT() {
        testBinaryOperator(new LesserThan(LEFT, RIGHT), "<");
    }

    @Test
    public void testMul() {
        testBinaryOperator(new Multiply(LEFT, RIGHT), "*");
    }

    @Test
    public void testSub() {
        testBinaryOperator(new Subtract(LEFT, RIGHT), "-");
    }

    @Test
    public void testNeg() {
        testUnaryOperator(new Negative(LEFT), "-");
    }

    @Test
    public void testPos() {
        testUnaryOperator(new Positive(LEFT), "+");
    }
}
