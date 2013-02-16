package org.uva.sea.ql.type.impl;

import org.uva.sea.ql.type.Type;

public class NumericType extends Type
{

    @Override
    public boolean isCompatibleTo(Type type)
    {
        return type.isCompatibleToNumeric();
    }

    @Override
    public boolean isCompatibleToNumeric()
    {
        return true;
    }

}
