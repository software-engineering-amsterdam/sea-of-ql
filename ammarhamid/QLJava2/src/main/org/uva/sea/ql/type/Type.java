package org.uva.sea.ql.type;

import org.uva.sea.ql.visitor.render.TypeWidgetVisitor;
import org.uva.sea.ql.widget.CustomWidget;

public abstract class Type
{
    public abstract CustomWidget accept(TypeWidgetVisitor typeWidgetVisitor);

    public abstract boolean isCompatibleTo(Type type);

    public boolean isCompatibleToInteger()
    {
        return false;
    }

    public boolean isCompatibleToBoolean()
    {
        return false;
    }

    public boolean isCompatibleToString()
    {
        return false;
    }

    public boolean isCompatibleToMoney()
    {
        return false;
    }

    public boolean isCompatibleToNumeric()
    {
        return false;
    }

}
