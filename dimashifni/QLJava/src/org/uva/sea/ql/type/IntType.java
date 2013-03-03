package org.uva.sea.ql.type;

import org.uva.sea.ql.visitor.type.TypeVisitor;

public class IntType extends NumericType {
    @Override
    public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean isCompatibleTo(Type type) {
        return type.isCompatibleToInteger();
    }

    @Override
    public boolean isCompatibleToInteger() {
        return true;
    }
}
