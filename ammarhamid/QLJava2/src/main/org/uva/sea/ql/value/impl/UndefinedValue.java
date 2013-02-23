package org.uva.sea.ql.value.impl;

import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.type.impl.UndefinedType;
import org.uva.sea.ql.value.Value;

public class UndefinedValue extends Value
{
    @Override
    public Type getType()
    {
        return new UndefinedType();
    }
}
