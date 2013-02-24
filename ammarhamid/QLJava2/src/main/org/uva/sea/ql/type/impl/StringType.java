package org.uva.sea.ql.type.impl;

import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.impl.TypeWidgetVisitor;
import org.uva.sea.ql.visitor.widget.CustomWidget;

public class StringType extends Type
{

    @Override
    public CustomWidget accept(TypeWidgetVisitor typeWidgetVisitor)
    {
        return typeWidgetVisitor.visit(this);
    }

    @Override
    public boolean isCompatibleTo(Type type)
    {
        return type.isCompatibleToString();
    }

    @Override
    public boolean isCompatibleToString()
    {
        return true;
    }

    @Override
    public String toString()
    {
        return "string";
    }
}
