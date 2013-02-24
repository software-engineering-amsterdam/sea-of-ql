package org.uva.sea.ql.value.impl;

import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.type.impl.UndefinedType;
import org.uva.sea.ql.value.Value;

public class UndefinedValue extends Value
{
    private final String value = "UNDEFINED";

    @Override
    public Type getType()
    {
        return new UndefinedType();
    }

    @Override
    public Object getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return value;
    }
}
