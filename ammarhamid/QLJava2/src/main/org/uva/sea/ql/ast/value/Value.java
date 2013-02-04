package org.uva.sea.ql.ast.value;

import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.expression.impl.IdentifierNode;
import org.uva.sea.ql.ast.value.impl.*;

public abstract class Value extends ExprNode
{

    public abstract boolean isCompatibleTo(Value value);

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

    public BooleanValue asBooleanValue()
    {
        return (BooleanValue) this;
    }

    public IntegerValue asIntegerValue()
    {
        return (IntegerValue) this;
    }

    public MoneyValue asMoneyValue()
    {
        return (MoneyValue) this;
    }

    public StringValue asStringValue()
    {
        return (StringValue) this;
    }

    public NumericValue asNumericValue()
    {
        return (NumericValue) this;
    }

    @Override
    public String toTreeString(final String indent)
    {
        return '\n' + indent + String.valueOf(evaluate());
    }

    @Override
    public String toString()
    {
        return evaluate().toString();
    }

}
