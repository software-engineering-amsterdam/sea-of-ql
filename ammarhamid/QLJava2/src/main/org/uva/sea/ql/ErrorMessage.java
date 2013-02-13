package org.uva.sea.ql;

import org.uva.sea.ql.ast.expression.ExprNode;

public class ErrorMessage
{
    private final String message;
    private final ExprNode exprNode;

    public ErrorMessage(final ExprNode exprNode, final String message)
    {
        this.exprNode = exprNode;
        this.message = message;
    }

    public ExprNode getExprNode()
    {
        return exprNode;
    }

    public String getMessage()
    {
        return message;
    }
}
