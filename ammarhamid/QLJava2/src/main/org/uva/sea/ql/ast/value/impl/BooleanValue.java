package org.uva.sea.ql.ast.value.impl;

import org.uva.sea.ql.ast.value.Value;

public class BooleanValue extends Value implements Comparable<BooleanValue>
{
    private Boolean value;

    public BooleanValue(final Boolean value)
    {
        this.value = value;
    }

    public BooleanValue(final String value)
    {
        this.value = Boolean.valueOf(value);
    }

    @Override
    public Value evaluate()
    {
        return this;
    }

    @Override
    public boolean isCompatibleTo(Value value)
    {
        return value.isCompatibleToBoolean();
    }

    @Override
    public boolean isCompatibleToBoolean()
    {
        return true;
    }

    public Boolean getValue()
    {
        return value;
    }

    public void setValue(final Boolean value)
    {
        this.value = value;
    }

    @Override
    public int compareTo(final BooleanValue o)
    {
        return this.value.compareTo(o.getValue());
    }

    @Override
    public boolean equals(final Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(o == null || getClass() != o.getClass())
        {
            return false;
        }

        BooleanValue that = (BooleanValue) o;
        return !(value != null ? !value.equals(that.value) : that.value != null);
    }

    @Override
    public int hashCode()
    {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString()
    {
        return this.value.toString();
    }
}
