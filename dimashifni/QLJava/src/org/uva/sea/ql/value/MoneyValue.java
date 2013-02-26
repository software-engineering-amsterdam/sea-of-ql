package org.uva.sea.ql.value;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 2/26/13
 * Time: 10:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class MoneyValue extends Value{
    private final Double value;

    public MoneyValue(Double value) {
        this.value = value;
    }

    @Override
    public Value add(Value value) {

        return value.addMoney(this);
    }

    @Override
    public Value addMoney(MoneyValue moneyValue) {
        return new MoneyValue(moneyValue.getValue() + this.getValue());
    }

    public Double getValue() {
        return value;
    }
}
