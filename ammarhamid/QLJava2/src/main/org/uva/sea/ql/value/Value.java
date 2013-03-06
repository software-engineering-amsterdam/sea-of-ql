package org.uva.sea.ql.value;

import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.value.impl.BooleanValue;
import org.uva.sea.ql.value.impl.IntegerValue;
import org.uva.sea.ql.value.impl.MoneyValue;

public abstract class Value
{
    public static final String UNSUPPORTED_OPERATION_EXCEPTION = "Unsupported operation exception";

    public abstract Type getType();
    public abstract Object getValue();

    public Value equal(Value value)
    {
        return new BooleanValue(this.equals(value));
    }

    public Value notEqual(Value value)
    {
        return new BooleanValue(!this.equals(value));
    }

    public Value not()
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value or(Value value)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value orBoolean(BooleanValue booleanValue)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value and(Value value)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value andBoolean(BooleanValue booleanValue)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value add(Value value)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value addInt(IntegerValue integerValue)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value addMoney(MoneyValue moneyValue)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value divide(Value value)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value divideInt(IntegerValue integerValue)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value divideMoney(MoneyValue moneyValue)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value multiply(Value value)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value multiplyInt(IntegerValue integerValue)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value multiplyMoney(MoneyValue moneyValue)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value subtract(Value value)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value subtractInt(IntegerValue integerValue)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value subtractMoney(MoneyValue moneyValue)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value greaterEqual(Value value)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value greaterEqualInt(IntegerValue integerValue)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value greaterEqualMoney(MoneyValue moneyValue)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value greaterThan(Value value)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value greaterThanInt(IntegerValue integerValue)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value greaterThanMoney(MoneyValue moneyValue)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value lessEqual(Value value)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value lessEqualInt(IntegerValue integerValue)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value lessEqualMoney(MoneyValue moneyValue)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value lessThan(Value value)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value lessThanInt(IntegerValue integerValue)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value lessThanMoney(MoneyValue moneyValue)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }

    public Value negate()
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }


}
