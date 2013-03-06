package org.uva.sea.ql.value.impl;

import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.type.impl.IntegerType;
import org.uva.sea.ql.value.Value;

public class IntegerValue extends Value implements Comparable<IntegerValue>
{
    private Integer value;

    public IntegerValue(final Integer value)
    {
        this.value = value;
    }

    public IntegerValue(final String value)
    {
        this.value = Integer.valueOf(value);
    }

    public Integer getValue()
    {
        return value;
    }

    @Override
    public Type getType()
    {
        return new IntegerType();
    }

    @Override
    public Value add(final Value value)
    {
        return value.addInt(this);
    }

    @Override
    public Value addInt(IntegerValue integerValue)
    {
        return new IntegerValue(integerValue.getValue() + getValue());
    }

    @Override
    public Value divide(Value value)
    {
        return value.divideInt(this);
    }

    @Override
    public Value divideInt(IntegerValue integerValue)
    {
        return new IntegerValue(integerValue.getValue() / getValue());
    }

    @Override
    public Value multiply(Value value)
    {
        return value.multiplyInt(this);
    }

    @Override
    public Value multiplyInt(IntegerValue integerValue)
    {
        return new IntegerValue(integerValue.getValue() * getValue());
    }

    @Override
    public Value subtract(Value value)
    {
        return value.subtractInt(this);
    }

    @Override
    public Value subtractInt(IntegerValue integerValue)
    {
        return new IntegerValue(integerValue.getValue() - getValue());
    }

    @Override
    public Value greaterEqual(Value value)
    {
        return value.greaterEqualInt(this);
    }

    @Override
    public Value greaterEqualInt(IntegerValue integerValue)
    {
        return new BooleanValue(integerValue.getValue() >= getValue());
    }

    @Override
    public Value greaterThan(Value value)
    {
        return value.greaterThanInt(this);
    }

    @Override
    public Value greaterThanInt(IntegerValue integerValue)
    {
        return new BooleanValue(integerValue.getValue() > getValue());
    }

    @Override
    public Value lessEqual(Value value)
    {
        return value.lessEqualInt(this);
    }

    @Override
    public Value lessEqualInt(IntegerValue integerValue)
    {
        return new BooleanValue(integerValue.getValue() <= getValue());
    }

    @Override
    public Value lessThan(Value value)
    {
        return value.lessThanInt(this);
    }

    @Override
    public Value lessThanInt(IntegerValue integerValue)
    {
        return new BooleanValue(integerValue.getValue() < getValue());
    }

    @Override
    public Value negate()
    {
        return new IntegerValue(-1 * this.value);
    }

    @Override
    public int compareTo(final IntegerValue o)
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

        IntegerValue that = (IntegerValue) o;
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

