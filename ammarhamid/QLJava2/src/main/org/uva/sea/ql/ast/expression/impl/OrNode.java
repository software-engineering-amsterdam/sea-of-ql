package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.ast.exception.InvalidTypeException;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.value.ValueNode;
import org.uva.sea.ql.ast.value.impl.BooleanNode;

public class OrNode extends ExprNode
{
    private final ExprNode lhs;
    private final ExprNode rhs;

    public OrNode(final ExprNode lhs, final ExprNode rhs)
    {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public ValueNode evaluate()
    {
        final ValueNode valueNode1 = this.lhs.evaluate();
        final ValueNode valueNode2 = this.rhs.evaluate();

        if(valueNode1.isBooleanNode() && valueNode2.isBooleanNode())
        {
            final BooleanNode booleanNode1 = valueNode1.asBooleanNode();
            final BooleanNode booleanNode2 = valueNode2.asBooleanNode();
            return new BooleanNode(booleanNode1.getValue() || booleanNode2.getValue());
        }

        throw new InvalidTypeException("Invalid operand type for or(||) operation: " + toTreeString(" "));
    }

    @Override
    public String toTreeString(String indent)
    {
        return '\n' + indent + "||" + lhs.toTreeString(indent + "  ")
                + rhs.toTreeString(indent + "  ");

    }
}
