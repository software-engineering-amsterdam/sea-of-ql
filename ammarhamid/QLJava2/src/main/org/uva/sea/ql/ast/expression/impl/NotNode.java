package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.ast.exception.InvalidTypeException;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.value.ValueNode;
import org.uva.sea.ql.ast.value.impl.BooleanNode;

public class NotNode extends ExprNode
{
    private final ExprNode exprNode;

    public NotNode(final ExprNode exprNode)
    {
        this.exprNode = exprNode;
    }

    @Override
    public ValueNode evaluate()
    {
        final ValueNode valueNode = this.exprNode.evaluate();

        if(valueNode.isBooleanNode())
        {
            return new BooleanNode(!valueNode.asBooleanNode().getValue());
        }

        throw new InvalidTypeException("Invalid operand type for not(!) operation: " + toTreeString(" "));
    }

    @Override
    public String toTreeString(String indent)
    {
        return '\n' + indent + "not(!)" + exprNode.toTreeString(indent + "  ");
    }
}
