package org.uva.sea.ql.ast.primary.typeClasses;

public class UndefinedType implements Type {

    @Override
    public String getObjectLiteralSimpleClassName() {
        return "Undefined";
    }

    @Override
    public boolean canBeAssignedFrom(String value) {
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
