package org.uva.sea.ql.type;

import org.uva.sea.ql.visitor.type.TypeVisitor;

public class NumericType extends Type {
    @Override
    public <T> T accept(TypeVisitor<T> visitor) {
        throw new UnsupportedOperationException("unsupported numeric type visitor");
    }

    @Override
    public boolean isCompatibleTo(Type type) {
        return type.isCompatibleToNumeric();
    }

    public boolean isCompatibleToNumeric()
    {
        return true;
    }
}
