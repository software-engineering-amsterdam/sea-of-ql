package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.uva.sea.ql.ast.expression.BinaryExpression;
import org.uva.sea.ql.ast.expression.UnaryExpression;

import static org.junit.Assert.assertEquals;

public abstract class OperatorTests extends KnockoutJSViewModelBuilderVisitorTests {

    protected abstract Object getLeftValue();
    protected abstract Object getRightValue();

    protected void testUnaryOperator(UnaryExpression unaryExpression, String operator) {
        unaryExpression.accept(visitor, context);
        assertEquals(String.format("(%s%s)", operator, getLeftValue()), context.getObjectHierarchy().toString());
    }

    protected void testBinaryOperator(BinaryExpression binaryExpression, String operator) {
        binaryExpression.accept(visitor, context);
        assertEquals(String.format("(%s%s%s)", getLeftValue(), operator, getRightValue()), context.getObjectHierarchy().toString());
    }

}
