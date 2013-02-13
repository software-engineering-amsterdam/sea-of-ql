package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.expression.UnaryNode;
import org.uva.sea.ql.value.Value;

public class NotNode extends UnaryNode
{

    public NotNode(final ExprNode exprNode)
    {
        super(exprNode);
    }

//    @Override
//    public Value evaluate()
//    {
//        final Value value = this.exprNode.evaluate();
//
//        if(value.isCompatibleToBoolean())
//        {
//            return new BooleanValue(!value.asBooleanValue().getValue());
//        }
//
//        throw new InvalidTypeException("Invalid operand type for not(!) operation: " + toTreeString(" "));
//    }


    @Override
    public Value evaluate()
    {
        final Value value = this.exprNode.evaluate();
        return value.not();
    }

//    @Override
//    public String toTreeString(final String indent)
//    {
//        return '\n' + indent + "not(!)" + exprNode.toTreeString(indent + "  ");
//    }
}
