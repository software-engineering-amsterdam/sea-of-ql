package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.value.Bool;

public class EqualsOperatorTests extends OperatorTests {

    private static final boolean LEFT_VALUE = true;
    private static final Bool LEFT = new Bool(LEFT_VALUE);
    private static final boolean RIGHT_VALUE = false;
    private static final Bool RIGHT = new Bool(RIGHT_VALUE);

    private static final String BINARY_PATTERN = "(%s%s%s)";

    @Override protected Object getLeftValue() { return LEFT_VALUE; }
    @Override protected Object getRightValue() { return RIGHT_VALUE; }

    @Test
    public void testEq() {
        testBinaryOperator(new Eq(LEFT, RIGHT), "==");
    }

    @Test
    public void testNeq() {
        testBinaryOperator(new NEq(LEFT, RIGHT), "!=");
    }

}
