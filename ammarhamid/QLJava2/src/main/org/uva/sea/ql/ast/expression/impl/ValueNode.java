package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.ErrorMessage;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.ExpressionVisitor;

import java.util.Collection;

public class ValueNode extends ExprNode
{
    private final Value value;

    public ValueNode(final Value value)
    {
        this.value = value;
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> expressionVisitor)
    {
        return expressionVisitor.visit(this);
    }

    @Override
    public Value evaluate()
    {
        return this.value;
    }

    @Override
    public boolean validate(Collection<ErrorMessage> errorMessages)
    {
        return true;
    }

    public ExprNode getExprNode()
    {
        return this;
    }
}
