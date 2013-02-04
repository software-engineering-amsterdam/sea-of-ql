package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.ast.exception.InvalidTypeException;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.value.Value;
import org.uva.sea.ql.ast.value.impl.IntegerValue;
import org.uva.sea.ql.ast.value.impl.MoneyValue;
import org.uva.sea.ql.ast.value.impl.NumericValue;
import org.uva.sea.ql.ast.value.impl.StringValue;

public class AddNode extends ExprNode
{
    private final ExprNode lhs;
    private final ExprNode rhs;

    public AddNode(final ExprNode lhs, final ExprNode rhs)
    {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public Value evaluate()
    {
        final Value value1 = this.lhs.evaluate();
        final Value value2 = this.rhs.evaluate();

        final Value result;
        if(value1.isCompatibleTo(value2))
        {
            final NumericValue numericValue1 = value1.asNumericValue();
            final NumericValue numericValue2 = value2.asNumericValue();
            result = numericValue1.add(numericValue2);
        }
        else
        {
            throw new InvalidTypeException("Invalid operand type for add(+) operation: " + toTreeString(" "));
        }

        return result;
    }

    @Override
    public String toTreeString(final String indent)
    {
        return '\n' + indent + "+" + lhs.toTreeString(indent + "  ")
                + rhs.toTreeString(indent + "  ");
    }

}
