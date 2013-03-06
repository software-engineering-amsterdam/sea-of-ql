package org.uva.sea.ql.type;

import org.uva.sea.ql.visitor.type.TypeVisitor;

public abstract class Type
{
    public abstract <T> T accept(TypeVisitor<T> visitor);
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
