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

    public Value addInt(IntegerValue integerValue)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value addMoney(MoneyValue moneyValue)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value and(Value value)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public Value andBoolean(BooleanValue booleanValue)
    {
        throw new UnsupportedOperationException("unsupported operation");
    }

}
