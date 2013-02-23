package org.uva.sea.ql.type.impl;

import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.TypeVisitor;

public class BooleanType extends Type
{

    @Override
    public void accept(TypeVisitor typeVisitor)
    {
        typeVisitor.visit(this);
    }

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

    @Override
    public String toString()
    {
        return "boolean";
    }
}
