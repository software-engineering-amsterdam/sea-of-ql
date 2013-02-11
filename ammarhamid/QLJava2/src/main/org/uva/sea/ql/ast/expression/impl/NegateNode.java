package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.ast.exception.InvalidTypeException;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.value.Value;
import org.uva.sea.ql.ast.value.impl.IntegerValue;
import org.uva.sea.ql.ast.value.impl.MoneyValue;

public class NegateNode extends ExprNode
{
    private final ExprNode exprNode;

    public NegateNode(final ExprNode exprNode)
    {
        this.exprNode = exprNode;
    }

    @Override
    public Value evaluate()
    {
        final Value value = this.exprNode.evaluate();

        final Value result;
        if(value.isCompatibleToNumeric())
        {
            result = value.asNumericValue().negate();
        }
        else
        {
            throw new InvalidTypeException("Invalid operand type for negate(-) operation: " + toTreeString(" "));
        }

        return result;
    }

    @Override
    public String toTreeString(final String indent)
    {
        return '\n' + indent + "negate(-)" + exprNode.toTreeString(indent + "  ");
    }
}
