package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.ast.expression.BinaryNode;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.value.Value;

public class GreaterEqualNode extends BinaryNode
{

    public GreaterEqualNode(final ExprNode lhs, final ExprNode rhs)
    {
        super(lhs, rhs);
    }

//    @Override
//    public Value evaluate()
//    {
//        final Value value1 = this.lhs.evaluate();
//        final Value value2 = this.rhs.evaluate();
//
//        final Value result;
//        if(value1.isCompatibleTo(value2))
//        {
//            final NumericValue numericValue1 = value1.asNumericValue();
//            final NumericValue numericValue2 = value2.asNumericValue();
//            result = numericValue1.greaterEqual(numericValue2);
//        }
//        else
//        {
//            throw new InvalidTypeException("Invalid operand type for greaterEqual(>=) operation: " + toTreeString(" "));
//        }
//
//        return result;
//    }


    @Override
    public Value evaluate()
    {
        final Value value1 = this.lhs.evaluate();
        final Value value2 = this.rhs.evaluate();
        return value1.greaterEqual(value2);
    }

//    @Override
//    public String toTreeString(final String indent)
//    {
//        return '\n' + indent + ">=" + lhs.toTreeString(indent + "  ")
//                + rhs.toTreeString(indent + "  ");
//
//    }
}
