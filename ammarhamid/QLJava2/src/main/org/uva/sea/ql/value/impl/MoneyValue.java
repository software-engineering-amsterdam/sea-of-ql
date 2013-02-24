package org.uva.sea.ql.value.impl;

import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.type.impl.MoneyType;
import org.uva.sea.ql.value.Value;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MoneyValue extends Value implements Comparable<MoneyValue>
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

    public BigDecimal getValue()
    {
        return value;
    }

    @Override
    public Type getType()
    {
        return new MoneyType();
    }

    @Override
    public Value add(Value value)
    {
        return value.addMoney(this);
    }

    @Override
    public Value addMoney(MoneyValue moneyValue)
    {
        return new MoneyValue(moneyValue.getValue().add(getValue()));
    }

    @Override
    public Value divide(Value value)
    {
        return value.divideMoney(this);
    }

    @Override
    public Value divideMoney(MoneyValue moneyValue)
    {
        return new MoneyValue(moneyValue.getValue().divide(getValue()));
    }

    @Override
    public Value multiply(Value value)
    {
        return value.multiplyMoney(this);
    }

    @Override
    public Value multiplyMoney(MoneyValue moneyValue)
    {
        return new MoneyValue(moneyValue.getValue().multiply(getValue()));
    }

    @Override
    public Value subtract(Value value)
    {
        return value.subtractMoney(this);
    }

    @Override
    public Value subtractMoney(MoneyValue moneyValue)
    {
        return new MoneyValue(moneyValue.getValue().subtract(getValue()));
    }

    @Override
    public Value greaterEqual(Value value)
    {
        return value.greaterEqualMoney(this);
    }

    @Override
    public Value greaterEqualMoney(MoneyValue moneyValue)
    {
        return new BooleanValue(moneyValue.getValue().compareTo(getValue()) >= 0);
    }

    @Override
    public Value greaterThan(Value value)
    {
        return value.greaterThanMoney(this);
    }

    @Override
    public Value greaterThanMoney(MoneyValue moneyValue)
    {
        return new BooleanValue(moneyValue.getValue().compareTo(getValue()) > 0);
    }

    @Override
    public Value lessEqual(Value value)
    {
        return value.lessEqualMoney(this);
    }

    @Override
    public Value lessEqualMoney(MoneyValue moneyValue)
    {
        return new BooleanValue(moneyValue.getValue().compareTo(getValue()) <= 0);
    }

    @Override
    public Value lessThan(Value value)
    {
        return value.lessThanMoney(this);
    }

    @Override
    public Value lessThanMoney(MoneyValue moneyValue)
    {
        return new BooleanValue(moneyValue.getValue().compareTo(getValue()) < 0);
    }

    @Override
    public Value negate()
    {
        return new MoneyValue(this.value.negate());
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
        final NumberFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(this.value);
    }
}
