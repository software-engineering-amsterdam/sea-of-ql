package org.uva.sea.ql.type.impl;

import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.render.TypeWidgetVisitor;
import org.uva.sea.ql.widget.CustomWidget;

public class NumericType extends Type
{

    @Override
    public CustomWidget accept(TypeWidgetVisitor typeWidgetVisitor)
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

    @Override
    public String toString()
    {
        return "numeric";
    }
}
