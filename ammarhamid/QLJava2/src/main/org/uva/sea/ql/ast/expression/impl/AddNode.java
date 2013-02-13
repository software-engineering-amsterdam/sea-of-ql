package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.ast.expression.BinaryNode;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.value.Value;

public class AddNode extends BinaryNode
{

    public AddNode(final ExprNode lhs, final ExprNode rhs)
    {
        super(lhs, rhs);
    }

    // TODO place it in visitor
    public void checkType()
    {
        final Type type1 = this.lhs.evaluate().getType();
        final Type type2 = this.rhs.evaluate().getType();

        boolean compatible = type1.isCompatibleTo(type2);

        if(!compatible)
        {
            // TODO do something !!
        }
    }

    @Override
    public Value evaluate()
    {
        final Value value1 = this.lhs.evaluate();
        final Value value2 = this.rhs.evaluate();
        return value1.add(value2);
    }

//    @Override
//    public String toTreeString(final String indent)
//    {
//        return '\n' + indent + "+" + lhs.toTreeString(indent + "  ")
//                + rhs.toTreeString(indent + "  ");
//    }

}
