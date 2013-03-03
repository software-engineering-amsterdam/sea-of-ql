package org.uva.sea.ql.type;

import org.uva.sea.ql.visitor.type.TypeVisitor;

public class StringType extends Type {

    @Override
    public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean isCompatibleTo(Type type) {
        return type.isCompatibleToString();
    }

    @Override
    public boolean isCompatibleToString() {
        return true;
    }
}
