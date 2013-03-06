package org.uva.sea.ql.ast.type;

public final class UndefinedType implements Type {

    @Override
    public String getName() {
        return "Undefined";
    }

    @Override
    public boolean canTakeValue(String value) {
        return false;
    }

    @Override
    public boolean isCompatibleTo(Type type) {
        return false;
    }

    @Override
    public boolean isCompatibleToBooleanType() {
        return false;
    }

    @Override
    public boolean isCompatibleToIntegerType() {
        return false;
    }

    @Override
    public boolean isCompatibleToStringType() {
        return false;
    }
}
