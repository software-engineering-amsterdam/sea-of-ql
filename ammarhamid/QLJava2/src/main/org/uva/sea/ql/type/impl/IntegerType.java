package org.uva.sea.ql.type.impl;

import org.uva.sea.ql.type.Type;

public class IntegerType extends NumericType
{

    @Override
    public boolean isCompatibleTo(Type type)
    {
        return type.isCompatibleToInteger();
    }

    @Override
    public boolean isCompatibleToInteger()
    {
        return true;
    }

}
