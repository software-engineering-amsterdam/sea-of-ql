package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.Message;

public abstract class UnaryNode extends ExprNode
{
    protected final ExprNode exprNode;

    public UnaryNode(final ExprNode exprNode)
    {
        this.exprNode = exprNode;
    }

    protected abstract String getOperator();

    protected Message createErrorMessage()
    {
        return new Message("Invalid type for " + getOperator() + ' ', this);
    }

    public ExprNode getExprNode()
    {
        return exprNode;
    }

    @Override
    public String toString()
    {
        return  getOperator() + exprNode.toString();
    }
}
