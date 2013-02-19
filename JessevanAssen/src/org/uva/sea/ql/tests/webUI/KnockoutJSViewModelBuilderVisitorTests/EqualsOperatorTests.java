package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.EqualTo;
import org.uva.sea.ql.ast.expression.NotEqualTo;
import org.uva.sea.ql.ast.expression.value.Bool;

public class EqualsOperatorTests extends OperatorTests {

    private static final boolean LEFT_VALUE = true;
    private static final Bool LEFT = new Bool(LEFT_VALUE);
    private static final boolean RIGHT_VALUE = false;
    private static final Bool RIGHT = new Bool(RIGHT_VALUE);

    @Override protected Object getLeftValue() { return LEFT_VALUE; }
    @Override protected Object getRightValue() { return RIGHT_VALUE; }

    @Test
    public void testEq() {
        testBinaryOperator(new EqualTo(LEFT, RIGHT), "==");
    }

    @Test
    public void testNeq() {
        testBinaryOperator(new NotEqualTo(LEFT, RIGHT), "!=");
    }

}
