package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.And;
import org.uva.sea.ql.ast.expression.Not;
import org.uva.sea.ql.ast.expression.Or;
import org.uva.sea.ql.ast.expression.value.Bool;

public class BooleanOperatorTests extends OperatorTests {

    private static final boolean LEFT_VALUE = true;
    private static final Bool LEFT = new Bool(LEFT_VALUE);
    private static final boolean RIGHT_VALUE = false;
    private static final Bool RIGHT = new Bool(RIGHT_VALUE);

    private static final String BINARY_PATTERN = "(%s%s%s)";

    @Override protected Object getLeftValue() { return LEFT_VALUE; }
    @Override protected Object getRightValue() { return RIGHT_VALUE; }

    @Test
    public void testAnd() {
        testBinaryOperator(new And(LEFT, RIGHT), "&&");
    }

    @Test
    public void testOr() {
        testBinaryOperator(new Or(LEFT, RIGHT), "||");
    }

    @Test
    public void testNot() {
        testUnaryOperator(new Not(LEFT), "!");
    }

}
