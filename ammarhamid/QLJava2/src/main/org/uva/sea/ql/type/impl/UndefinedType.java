package org.uva.sea.ql.type.impl;

import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.TypeVisitor;

public class UndefinedType extends Type
{

    @Override
    public void accept(TypeVisitor typeVisitor)
    {
        throw new UnsupportedOperationException("Unsupported operation: UNDEFINED type");
    }

    @Override
    public boolean isCompatibleTo(Type type)
    {
        throw new UnsupportedOperationException("Unsupported operation: UNDEFINED type");
    }

}
