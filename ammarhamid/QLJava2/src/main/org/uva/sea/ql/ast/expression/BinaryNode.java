package org.uva.sea.ql.ast.expression;

public abstract class BinaryNode extends ExprNode
{
    protected final ExprNode lhs;
    protected final ExprNode rhs;

    protected BinaryNode(final ExprNode lhs, final ExprNode rhs)
    {
        this.lhs = lhs;
        this.rhs = rhs;
    }

}
