package org.uva.sea.ql;

import org.uva.sea.ql.ast.expression.ExprNode;

public class Message
{
    private final String message;
    private final ExprNode exprNode;

    public Message(final String message, final ExprNode exprNode)
    {
        this.message = message;
        this.exprNode = exprNode;
    }

    public String getMessage()
    {
        return message;
    }

    @Override
    public String toString()
    {
        return "* " + message + '\'' + exprNode +'\'' ;
    }
}
