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

    @Override
    public Value div(Value value) {
        return value.divInt(this);
    }

    @Override
    public Value divInt(IntegerValue integerValue) {
        return new IntegerValue(integerValue.getValue() / this.getValue());
    }

    @Override
    public Value eq(Value value) {
        return value.eqInt(this);
    }

    @Override
    public Value eqInt(IntegerValue integerValue) {
        return new BooleanValue(integerValue.getValue() == this.getValue());
    }

    @Override
    public Value gEq(Value value) {
        return value.gEqInt(this);
    }

    @Override
    public Value gEqInt(IntegerValue value) {
        return new BooleanValue(value.getValue() >= this.getValue());
    }

    @Override
    public Value gT(Value value) {
        return value.gTInt(this);
    }

    @Override
    public Value gTInt(IntegerValue value) {
        return new BooleanValue(value.getValue() > this.getValue());
    }

    @Override
    public Value lEq(Value value) {
        return value.lEqInt(this);
    }

    @Override
    public Value lEqInt(IntegerValue value) {
        return new BooleanValue(value.getValue() <= this.getValue());
    }

    @Override
    public Value lT(Value value) {
        return value.lTInt(this);
    }

    @Override
    public Value lTInt(IntegerValue value) {
        return new BooleanValue(value.getValue() < this.getValue());
    }

    @Override
    public Value mul(Value value) {
        return value.mulInt(this);
    }

    @Override
    public Value mulInt(IntegerValue value) {
        return new BooleanValue(value.getValue() != this.getValue());
    }

    public Integer getValue() {
        return value;
    }
}
