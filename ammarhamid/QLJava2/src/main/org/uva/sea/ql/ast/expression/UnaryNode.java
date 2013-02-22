package org.uva.sea.ql.ast.expression;

public abstract class UnaryNode extends ExprNode
{
    protected final ExprNode exprNode;

    public UnaryNode(final ExprNode exprNode)
    {
        this.exprNode = exprNode;
    }

    public ExprNode getExprNode()
    {
        return exprNode;
    }
}
