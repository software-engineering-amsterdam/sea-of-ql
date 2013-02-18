package org.uva.sea.ql.ast.primary.typeClasses;

import org.uva.sea.ql.ast.primary.Bool;

public class BooleanType implements Type {

    @Override
    public String getObjectLiteralSimpleClassName() {
        return Bool.class.getSimpleName();
    }

    @Override
    public boolean canBeAssignedFrom(String value) {
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
