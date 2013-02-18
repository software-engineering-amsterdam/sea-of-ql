package org.uva.sea.ql.type.impl;

import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.TypeVisitor;

public class IntegerType extends NumericType
{

    @Override
    public void accept(TypeVisitor typeVisitor)
    {
        typeVisitor.visit(this);
    }

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
