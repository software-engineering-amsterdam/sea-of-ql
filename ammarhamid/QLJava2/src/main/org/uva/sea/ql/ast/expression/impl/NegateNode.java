package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.expression.UnaryNode;
import org.uva.sea.ql.value.Value;

public class NegateNode extends UnaryNode
{

    public NegateNode(final ExprNode exprNode)
    {
        super(exprNode);
    }

//    @Override
//    public Value evaluate()
//    {
//        final Value value = this.exprNode.evaluate();
//
//        final Value result;
//        if(value.isCompatibleToNumeric())
//        {
//            result = value.asNumericValue().negate();
//        }
//        else
//        {
//            throw new InvalidTypeException("Invalid operand type for negate(-) operation: " + toTreeString(" "));
//        }
//
//        return result;
//    }

    @Override
    public Value evaluate()
    {
        final Value value = this.exprNode.evaluate();
        return value.negate();
    }

//    @Override
//    public String toTreeString(final String indent)
//    {
//        return '\n' + indent + "negate(-)" + exprNode.toTreeString(indent + "  ");
//    }
}
