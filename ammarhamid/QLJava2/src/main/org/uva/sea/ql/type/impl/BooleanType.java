package org.uva.sea.ql.type.impl;

import org.uva.sea.ql.type.Type;

public class BooleanType extends Type
{

    @Override
    public boolean isCompatibleTo(Type type)
    {
        return type.isCompatibleToBoolean();
    }

    @Override
    public boolean isCompatibleToBoolean()
    {
        return true;
    }
}
