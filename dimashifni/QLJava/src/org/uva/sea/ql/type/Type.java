package org.uva.sea.ql.type;

import org.uva.sea.ql.visitor.type.TypeVisitor;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 2/27/13
 * Time: 10:57 PM
 * To change this template use File | Settings | File Templates.
 */
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
