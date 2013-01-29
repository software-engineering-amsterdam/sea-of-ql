package org.uva.sea.ql.ast.primary.typeClasses;

import org.junit.Test;

public class StringType implements Type {

    @Test
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
