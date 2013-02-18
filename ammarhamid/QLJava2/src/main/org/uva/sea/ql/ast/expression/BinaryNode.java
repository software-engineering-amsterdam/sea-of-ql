package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ErrorMessage;
import org.uva.sea.ql.type.Type;

import java.util.Collection;

public abstract class BinaryNode extends ExprNode
{
    protected final ExprNode lhs;
    protected final ExprNode rhs;

    protected BinaryNode(final ExprNode lhs, final ExprNode rhs)
    {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public boolean validate(final Collection<ErrorMessage> errors)
    {
        final Type type1 = this.lhs.evaluate().getType();
        final Type type2 = this.rhs.evaluate().getType();
        final boolean compatible = type1.isCompatibleTo(type2);

        if(!compatible)
        {
            errors.add(new ErrorMessage(this, "Invalid type for " + getOperator()));
        }

        return compatible;
    }

    protected abstract String getOperator();

    @Override
    public String toString()
    {
        return lhs.toString() + getOperator() + rhs.toString();
    }

}
