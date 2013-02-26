package org.uva.sea.ql.value;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 2/26/13
 * Time: 10:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class IntegerValue extends Value {

    private final Integer value;

    public IntegerValue(Integer value) {
        this.value = value;
    }

    @Override
    public Value add(Value value) {
        return value.addInt(this);
    }

    @Override
    public Value addInt(IntegerValue integerValue) {
        return new IntegerValue(integerValue.getValue() + getValue());
    }

    public Integer getValue() {
        return value;
    }
}
