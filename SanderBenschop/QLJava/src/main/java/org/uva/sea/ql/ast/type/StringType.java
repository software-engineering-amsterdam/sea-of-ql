package org.uva.sea.ql.ast.type;

public final class StringType implements Type {

    @Override
    public String getName() {
        return "Str";
    }

    @Override
    public boolean canTakeValue(String value) {
        return value != null;
    }

    @Override
    public boolean isCompatibleTo(Type type) {
        return type.isCompatibleToStringType();
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
        return true;
    }
}
