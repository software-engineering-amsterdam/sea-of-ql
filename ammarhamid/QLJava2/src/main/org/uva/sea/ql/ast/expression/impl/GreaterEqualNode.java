package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.ast.expression.ArithmeticOperation;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class GreaterEqualNode extends ArithmeticOperation
{

    public GreaterEqualNode(final ExprNode lhs, final ExprNode rhs)
    {
        super(lhs, rhs);
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> expressionVisitor)
    {
        return expressionVisitor.visit(this);
    }

    @Override
    public Value evaluate()
    {
        final Value value1 = this.lhs.evaluate();
        final Value value2 = this.rhs.evaluate();
        return value1.greaterEqual(value2);
    }

    @Override
    protected String getOperator()
    {
        return ">=";
    }
}
