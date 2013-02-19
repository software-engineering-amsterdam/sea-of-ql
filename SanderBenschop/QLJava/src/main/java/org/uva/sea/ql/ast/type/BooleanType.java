package org.uva.sea.ql.ast.type;

public final class BooleanType implements Type {

    @Override
    public String getName() {
        return "Bool";
    }

    @Override
    public boolean canTakeValue(String value) {
        return value.equals("true") || value.equals("false");
    }

    @Override
    public boolean isCompatibleTo(Type type) {
        return type.isCompatibleToBooleanType();
    }

    @Override
    public boolean isCompatibleToBooleanType() {
        return true;
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
