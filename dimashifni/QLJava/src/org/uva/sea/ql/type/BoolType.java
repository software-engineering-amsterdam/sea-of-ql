package org.uva.sea.ql.type;

import org.uva.sea.ql.visitor.type.TypeVisitor;

public class BoolType extends Type {

    @Override
    public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean isCompatibleTo(Type type) {
        return type.isCompatibleToBoolean();
    }

    @Override
    public boolean isCompatibleToBoolean() {
        return true;
    }
}
