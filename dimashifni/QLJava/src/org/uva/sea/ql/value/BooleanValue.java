package org.uva.sea.ql.value;

import org.uva.sea.ql.type.BoolType;
import org.uva.sea.ql.type.Type;

public class BooleanValue extends Value{
    private final Boolean value;

    public BooleanValue(Boolean value) {
        this.value = value;
    }

    @Override
    public Value and(Value value) {
        return value.andBoolean(this);
    }

    @Override
    public Value andBoolean(BooleanValue booleanValue) {
        return new BooleanValue(booleanValue.getValue() && getValue());
    }

    @Override
    public Value eq(Value value) {
        return value.eqBoolean(this);
    }

    @Override
    public Value eqBoolean(BooleanValue booleanValue) {
        return new BooleanValue(booleanValue.getValue() == getValue());
    }

    @Override
    public Value or(Value value) {
        return value.orBoolean(this);
    }

    @Override
    public Value orBoolean(BooleanValue booleanValue) {
        return new BooleanValue(booleanValue.getValue() || getValue());
    }

    @Override
    public Value not() {
        return new BooleanValue(!getValue());
    }

    public Boolean getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public Type getType() {
        return new BoolType();
    }
}
