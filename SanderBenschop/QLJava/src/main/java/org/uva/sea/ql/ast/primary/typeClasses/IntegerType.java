package org.uva.sea.ql.ast.primary.typeClasses;

import org.uva.sea.ql.ast.primary.Int;

public class IntegerType implements Type {

    @Override
    public String getObjectLiteralSimpleClassName() {
        return Int.class.getSimpleName();
    }

    @Override
    public boolean canBeAssignedFromValue(String value) {
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
