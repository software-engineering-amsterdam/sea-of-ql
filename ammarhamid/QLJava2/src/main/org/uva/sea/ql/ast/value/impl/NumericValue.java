package org.uva.sea.ql.ast.value.impl;

import org.uva.sea.ql.ast.value.Value;

public abstract class NumericValue extends Value
{
    public abstract Value evaluate();
    public abstract Value add(NumericValue numericValue);
    public abstract Value divide(NumericValue numericValue);
    public abstract Value multiply(NumericValue numericValue);
    public abstract Value subtract(NumericValue numericValue);
    public abstract Value greaterEqual(NumericValue numericValue);
    public abstract Value greaterThan(NumericValue numericValue);
    public abstract Value lessEqual(NumericValue numericValue);
    public abstract Value lessThan(NumericValue numericValue);
    public abstract Value negate();

    @Override
    public boolean isCompatibleTo(Value value)
    {
        return value.isCompatibleToNumeric();
    }

    @Override
    public boolean isCompatibleToNumeric()
    {
        return true;
    }
}
