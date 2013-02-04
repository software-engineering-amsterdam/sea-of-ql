package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.ast.exception.InvalidTypeException;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.value.Value;
import org.uva.sea.ql.ast.value.impl.BooleanValue;

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
    public Value evaluate()
    {
        final Value value1 = this.lhs.evaluate();
        final Value value2 = this.rhs.evaluate();

        if(value1.isCompatibleTo(value2))
        {
            final BooleanValue booleanValue1 = value1.asBooleanValue();
            final BooleanValue booleanValue2 = value2.asBooleanValue();
            return new BooleanValue(booleanValue1.getValue() || booleanValue2.getValue());
        }

        throw new InvalidTypeException("Invalid operand type for or(||) operation: " + toTreeString(" "));
    }

    @Override
    public String toTreeString(final String indent)
    {
        return '\n' + indent + "||" + lhs.toTreeString(indent + "  ")
                + rhs.toTreeString(indent + "  ");

    }
}
