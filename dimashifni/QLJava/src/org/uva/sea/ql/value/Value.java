package org.uva.sea.ql.value;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 2/26/13
 * Time: 10:37 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Value {

    public abstract Object getValue();

    public Value add(Value value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value and(Value value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value div(Value value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value eq(Value value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value gEq(Value value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value gT(Value value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value lEq(Value value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value lT(Value value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value mul(Value value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value nEq(Value value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value addInt(IntegerValue integerValue)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value divInt(IntegerValue integerValue)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value eqInt(IntegerValue value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value gEqInt(IntegerValue value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value gTInt(IntegerValue value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value lEqInt(IntegerValue value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value lTInt(IntegerValue value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value mulInt(IntegerValue value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value nEqInt(IntegerValue value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value addMoney(MoneyValue moneyValue)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value divMoney(MoneyValue integerValue)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value eqMoney(MoneyValue value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value gEqMoney(MoneyValue value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value gTMoney(MoneyValue value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value lEqMoney(MoneyValue value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value lTMoney(MoneyValue value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value mulMoney(MoneyValue value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value nEqMoney(MoneyValue value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value andBoolean(BooleanValue booleanValue)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value eqBoolean(BooleanValue value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value or(Value value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value orBoolean(BooleanValue booleanValue)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

}
