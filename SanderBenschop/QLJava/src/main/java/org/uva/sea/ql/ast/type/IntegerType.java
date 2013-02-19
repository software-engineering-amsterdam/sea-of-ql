package org.uva.sea.ql.ast.type;

public final class IntegerType implements Type {

    @Override
    public String getName() {
        return "Int";
    }

    @Override
    public boolean canTakeValue(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    @Override
    public boolean isCompatibleTo(Type type) {
        return type.isCompatibleToIntegerType();
    }

    @Override
    public boolean isCompatibleToBooleanType() {
        return false;
    }

    @Override
    public boolean isCompatibleToIntegerType() {
        return true;
    }

    @Override
    public boolean isCompatibleToStringType() {
        return false;
    }
}
