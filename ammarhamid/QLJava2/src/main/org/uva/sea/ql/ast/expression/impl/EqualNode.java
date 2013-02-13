package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.ast.expression.BinaryNode;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.value.Value;

public class EqualNode extends BinaryNode
{

    public EqualNode(final ExprNode lhs, final ExprNode rhs)
    {
        super(lhs, rhs);
    }

//    @Override
//    public Value evaluate()
//    {
//        final Value value1 = this.lhs.evaluate();
//        final Value value2 = this.rhs.evaluate();
//
//        return new BooleanValue(value1.evaluate().equals(value2.evaluate()));
//    }


    @Override
    public Value evaluate()
    {
        final Value value1 = this.lhs.evaluate();
        final Value value2 = this.rhs.evaluate();
        return value1.equal(value2);
    }

//    @Override
//    public String toTreeString(final String indent)
//    {
//        return '\n' + indent + "==" + lhs.toTreeString(indent + "  ")
//                + rhs.toTreeString(indent + "  ");
//
//    }
}
