package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.uva.sea.ql.ast.expr.BinaryExpr;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.UnaryExpr;

import static org.junit.Assert.assertEquals;

public abstract class OperatorTests extends KnockoutJSViewModelBuilderVisitorTests {

    protected abstract Object getLeftValue();
    protected abstract Object getRightValue();

    protected void testUnaryOperator(UnaryExpr unaryExpr, String operator) {
        unaryExpr.accept(visitor, context);
        assertEquals(String.format("(%s%s)", operator, getLeftValue()), context.getObjectHierarchy().toString());
    }

    protected void testBinaryOperator(BinaryExpr binaryExpr, String operator) {
        binaryExpr.accept(visitor, context);
        assertEquals(String.format("(%s%s%s)", getLeftValue(), operator, getRightValue()), context.getObjectHierarchy().toString());
    }

}
