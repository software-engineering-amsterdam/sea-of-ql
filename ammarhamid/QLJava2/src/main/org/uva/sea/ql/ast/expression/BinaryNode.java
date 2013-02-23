package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.Message;

public abstract class BinaryNode extends ExprNode
{
    protected final ExprNode lhs;
    protected final ExprNode rhs;

    protected BinaryNode(final ExprNode lhs, final ExprNode rhs)
    {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public ExprNode getLhs()
    {
        return lhs;
    }

    public ExprNode getRhs()
    {
        return rhs;
    }

    protected abstract String getOperator();

    protected Message createErrorMessage()
    {
        return new Message("Invalid type for " + getOperator() + ' ', this);
    }

    @Override
    public String toString()
    {
        return lhs.toString() + getOperator() + rhs.toString();
    }

}
