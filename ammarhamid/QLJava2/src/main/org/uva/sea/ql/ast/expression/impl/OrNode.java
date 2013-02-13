package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.ast.expression.BinaryNode;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.value.Value;

public class OrNode extends BinaryNode
{

    public OrNode(final ExprNode lhs, final ExprNode rhs)
    {
        super(lhs, rhs);
    }

//    @Override
//    public Value evaluate()
//    {
//        final Value value1 = this.lhs.evaluate();
//        final Value value2 = this.rhs.evaluate();
//
//        if(value1.isCompatibleTo(value2))
//        {
//            final BooleanValue booleanValue1 = value1.asBooleanValue();
//            final BooleanValue booleanValue2 = value2.asBooleanValue();
//            return new BooleanValue(booleanValue1.getValue() || booleanValue2.getValue());
//        }
//
//        throw new InvalidTypeException("Invalid operand type for or(||) operation: " + toTreeString(" "));
//    }

    @Override
    public Value evaluate()
    {
        final Value value1 = this.lhs.evaluate();
        final Value value2 = this.rhs.evaluate();
        return value1.or(value2);
    }

//    @Override
//    public String toTreeString(final String indent)
//    {
//        return '\n' + indent + "||" + lhs.toTreeString(indent + "  ")
//                + rhs.toTreeString(indent + "  ");
//    }
}
