package org.uva.sea.ql.type.impl;

import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.render.TypeWidgetVisitor;
import org.uva.sea.ql.widget.CustomWidget;

public class MoneyType extends NumericType
{

    @Override
    public CustomWidget accept(TypeWidgetVisitor typeWidgetVisitor)
    {
        return typeWidgetVisitor.visit(this);
    }

    @Override
    public boolean isCompatibleTo(Type type)
    {
        return type.isCompatibleToMoney();
    }

    @Override
    public boolean isCompatibleToMoney()
    {
        return true;
    }

    @Override
    public String toString()
    {
        return "money";
    }
}
