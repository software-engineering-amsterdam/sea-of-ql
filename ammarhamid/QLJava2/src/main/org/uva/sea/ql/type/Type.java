package org.uva.sea.ql.type;

import org.uva.sea.ql.visitor.TypeVisitor;

public abstract class Type
{
    public abstract void accept(TypeVisitor typeVisitor);

    public abstract boolean isCompatibleTo(Type type);

    public boolean isCompatibleToInteger()
    {
        return false;
    }

    public boolean isCompatibleToBoolean()
    {
        return false;
    }

    public boolean isCompatibleToString()
    {
        return false;
    }

    public boolean isCompatibleToMoney()
    {
        return false;
    }

    public boolean isCompatibleToNumeric()
    {
        return false;
    }

}
