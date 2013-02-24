package org.uva.sea.ql.type.impl;

import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.impl.TypeWidgetVisitor;
import org.uva.sea.ql.visitor.widget.CustomWidget;

public class IntegerType extends NumericType
{

    @Override
    public CustomWidget accept(TypeWidgetVisitor typeWidgetVisitor)
    {
        return typeWidgetVisitor.visit(this);
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

    @Override
    public String toString()
    {
        return "integer";
    }

}
