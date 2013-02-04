package org.uva.sea.ql.ast.value.impl;

import org.uva.sea.ql.ast.value.Value;
import java.math.BigDecimal;

public class MoneyValue extends NumericValue implements Comparable<MoneyValue>
{
    private BigDecimal value;

    public MoneyValue(final String value)
    {
        this.value = new BigDecimal(value);
    }

    public MoneyValue(final BigDecimal value)
    {
        this.value = value;
    }

    @Override
    public Value evaluate()
    {
        return this;
    }

    @Override
    public boolean isCompatibleTo(Value value)
    {
        return value.isCompatibleToMoney();
    }

    @Override
    public boolean isCompatibleToMoney()
    {
        return true;
    }

    @Override
    public Value add(NumericValue numericValue)
    {
        return new MoneyValue(this.value.add(numericValue.asMoneyValue().getValue()));
    }

    @Override
    public Value divide(NumericValue numericValue)
    {
        return new MoneyValue(this.value.divide(numericValue.asMoneyValue().getValue()));
    }

    @Override
    public Value multiply(NumericValue numericValue)
    {
        return new MoneyValue(this.value.multiply(numericValue.asMoneyValue().getValue()));
    }

    @Override
    public Value subtract(NumericValue numericValue)
    {
        return new MoneyValue(this.value.subtract(numericValue.asMoneyValue().getValue()));
    }

    @Override
    public Value greaterEqual(NumericValue numericValue)
    {
        return new BooleanValue(this.value.compareTo(numericValue.asMoneyValue().getValue()) >= 0);
    }

    @Override
    public Value greaterThan(NumericValue numericValue)
    {
        return new BooleanValue(this.value.compareTo(numericValue.asMoneyValue().getValue()) > 0);
    }

    @Override
    public Value lessEqual(NumericValue numericValue)
    {
        return new BooleanValue(this.value.compareTo(numericValue.asMoneyValue().getValue()) <= 0);
    }

    @Override
    public Value lessThan(NumericValue numericValue)
    {
        return new BooleanValue(this.value.compareTo(numericValue.asMoneyValue().getValue()) < 0);
    }

    @Override
    public Value negate()
    {
        return new MoneyValue(this.value.negate());
    }

    public BigDecimal getValue()
    {
        return value;
    }

    public void setValue(final BigDecimal value)
    {
        this.value = value;
    }

    @Override
    public int compareTo(final MoneyValue o)
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

        MoneyValue that = (MoneyValue) o;
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
