package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.ast.exception.InvalidTypeException;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.value.ValueNode;
import org.uva.sea.ql.ast.value.impl.IntegerNode;
import org.uva.sea.ql.ast.value.impl.MoneyNode;

public class NegateNode extends ExprNode
{
    private final ExprNode exprNode;

    public NegateNode(final ExprNode exprNode)
    {
        this.exprNode = exprNode;
    }

    @Override
    public ValueNode evaluate()
    {
        final ValueNode valueNode = this.exprNode.evaluate();

        final ValueNode result;
        if(valueNode.isIntegerNode())
        {
            result = new IntegerNode(-valueNode.asIntegerNode().getValue());
        }
        else if(valueNode.isMoneyNode())
        {
            result = new MoneyNode(valueNode.asMoneyNode().getValue().negate());
        }
        else
        {
            throw new InvalidTypeException("Invalid operand type for negate(-) operation: " + toTreeString(" "));
        }

        return result;
    }

    @Override
    public String toTreeString(String indent)
    {
        return '\n' + indent + "negate(-)" + exprNode.toTreeString(indent + "  ");
    }
}
