package org.uva.sea.ql.ast.primary.typeClasses;

import org.junit.Test;

public class BooleanType implements Type {

    @Test
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
