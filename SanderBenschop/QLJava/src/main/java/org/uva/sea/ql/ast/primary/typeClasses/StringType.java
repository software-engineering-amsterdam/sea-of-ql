package org.uva.sea.ql.ast.primary.typeClasses;

import org.junit.Test;
import org.uva.sea.ql.ast.primary.Str;

public class StringType implements Type {

    @Override
    public String getObjectLiteralSimpleClassName() {
        return Str.class.getSimpleName();
    }

    @Override
    public boolean canBeAssignedFrom(String value) {
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
