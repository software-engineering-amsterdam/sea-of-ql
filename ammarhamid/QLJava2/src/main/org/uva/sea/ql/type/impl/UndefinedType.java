package org.uva.sea.ql.type.impl;

import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.render.TypeWidgetVisitor;
import org.uva.sea.ql.widget.CustomWidget;

public class UndefinedType extends Type
{

    @Override
    public CustomWidget accept(TypeWidgetVisitor typeWidgetVisitor)
    {
        throw new UnsupportedOperationException("Unsupported operation: UNDEFINED type");
    }

    @Override
    public boolean isCompatibleTo(Type type)
    {
        throw new UnsupportedOperationException("Unsupported operation: UNDEFINED type");
    }

    @Override
    public String toString()
    {
        return "UNDEFINED";
    }
}
