package org.uva.sea.ql.type.impl;

import org.uva.sea.ql.type.Type;

public class MoneyType extends NumericType
{

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

}
