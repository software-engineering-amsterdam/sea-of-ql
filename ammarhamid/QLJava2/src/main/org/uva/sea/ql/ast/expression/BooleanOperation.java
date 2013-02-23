package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.Message;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.type.impl.BooleanType;

import java.util.Collection;

public abstract class BooleanOperation extends BinaryNode
{
    protected BooleanOperation(ExprNode lhs, ExprNode rhs)
    {
        super(lhs, rhs);
    }

    @Override
    public boolean validate(Collection<Message> errors)
    {
        if(!(this.lhs.validate(errors) && this.rhs.validate(errors)))
        {
            return false;
        }

        final Type lhsType = this.lhs.getType();
        final Type rhsType = this.rhs.getType();
        boolean compatible = lhsType.isCompatibleToBoolean() && rhsType.isCompatibleToBoolean();
        if(!compatible)
        {
            errors.add(createErrorMessage());
        }

        return compatible;
    }

    @Override
    public Type getType()
    {
        return new BooleanType();
    }
}
