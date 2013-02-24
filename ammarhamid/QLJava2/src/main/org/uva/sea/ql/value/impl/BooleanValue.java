package org.uva.sea.ql.value.impl;

import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.type.impl.BooleanType;
import org.uva.sea.ql.value.Value;

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

    public Boolean getValue()
    {
        return value;
    }

    @Override
    public Type getType()
    {
        return new BooleanType();
    }

    @Override
    public Value not()
    {
        return new BooleanValue(!this.getValue());
    }

    @Override
    public Value or(Value value)
    {
        return value.orBoolean(this);
    }

    @Override
    public Value orBoolean(BooleanValue booleanValue)
    {
        return new BooleanValue(booleanValue.getValue() || getValue());
    }

    @Override
    public Value and(Value value)
    {
        return value.andBoolean(this);
    }

    @Override
    public Value andBoolean(BooleanValue booleanValue)
    {
        return new BooleanValue(booleanValue.getValue() && getValue());
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
