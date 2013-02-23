package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.ast.expression.BooleanOperation;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.value.impl.BooleanValue;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class OrNode extends BooleanOperation
{

    public OrNode(final ExprNode lhs, final ExprNode rhs)
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
        Value value1 = this.lhs.evaluate();
        Value value2 = this.rhs.evaluate();
        value1 = (value1 == null) ? new BooleanValue(false) : value1;
        value2 = (value2 == null) ? new BooleanValue(false) : value2;

        return value1.or(value2);
    }

    @Override
    protected String getOperator()
    {
        return "||";
    }
}
