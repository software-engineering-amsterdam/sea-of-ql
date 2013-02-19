package org.uva.sea.ql.type.impl;

import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.TypeVisitor;

public class NumericType extends Type
{

    @Override
    public void accept(TypeVisitor typeVisitor)
    {
        throw new UnsupportedOperationException("Unsupported type visitor: numeric");
    }

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
