package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.ast.exception.InvalidTypeException;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.value.Value;
import org.uva.sea.ql.ast.value.impl.BooleanValue;

public class NotNode extends ExprNode
{
    private final ExprNode exprNode;

    public NotNode(final ExprNode exprNode)
    {
        this.exprNode = exprNode;
    }

    @Override
    public Value evaluate()
    {
        final Value value = this.exprNode.evaluate();

        if(value.isCompatibleToBoolean())
        {
            return new BooleanValue(!value.asBooleanValue().getValue());
        }

        throw new InvalidTypeException("Invalid operand type for not(!) operation: " + toTreeString(" "));
    }

    @Override
    public String toTreeString(final String indent)
    {
        return '\n' + indent + "not(!)" + exprNode.toTreeString(indent + "  ");
    }
}
