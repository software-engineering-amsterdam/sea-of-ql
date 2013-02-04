package org.uva.sea.ql.ast.value.impl;

import org.uva.sea.ql.ast.value.Value;

public class IntegerValue extends NumericValue implements Comparable<IntegerValue>
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

    @Override
    public Value evaluate()
    {
        return this;
    }

    @Override
    public Value add(final NumericValue numericValue)
    {
        return new IntegerValue(this.value + numericValue.asIntegerValue().getValue());
    }

    @Override
    public Value divide(NumericValue numericValue)
    {
        return new IntegerValue(this.value / numericValue.asIntegerValue().getValue());
    }

    @Override
    public Value multiply(NumericValue numericValue)
    {
        return new IntegerValue(this.value * numericValue.asIntegerValue().getValue());
    }

    @Override
    public Value subtract(NumericValue numericValue)
    {
        return new IntegerValue(this.value - numericValue.asIntegerValue().getValue());
    }

    @Override
    public Value greaterEqual(NumericValue numericValue)
    {
        return new BooleanValue(this.value >= numericValue.asIntegerValue().getValue());
    }

    @Override
    public Value greaterThan(NumericValue numericValue)
    {
        return new BooleanValue(this.value > numericValue.asIntegerValue().getValue());
    }

    @Override
    public Value lessEqual(NumericValue numericValue)
    {
        return new BooleanValue(this.value <= numericValue.asIntegerValue().getValue());
    }

    @Override
    public Value lessThan(NumericValue numericValue)
    {
        return new BooleanValue(this.value < numericValue.asIntegerValue().getValue());
    }

    @Override
    public Value negate()
    {
        return new IntegerValue(-1 * this.value);
    }

    @Override
    public boolean isCompatibleTo(Value value)
    {
        return value.isCompatibleToInteger();
    }

    @Override
    public boolean isCompatibleToInteger()
    {
        return true;
    }

    public Integer getValue()
    {
        return value;
    }

    public void setValue(final Integer value)
    {
        this.value = value;
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

