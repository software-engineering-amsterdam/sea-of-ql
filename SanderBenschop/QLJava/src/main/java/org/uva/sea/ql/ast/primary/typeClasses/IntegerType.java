package org.uva.sea.ql.ast.primary.typeClasses;

import org.junit.Test;

public class IntegerType implements Type {

    @Test
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
