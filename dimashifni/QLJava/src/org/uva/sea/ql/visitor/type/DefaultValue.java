package org.uva.sea.ql.visitor.type;

import org.uva.sea.ql.type.*;
import org.uva.sea.ql.value.*;
import org.uva.sea.ql.value.StringValue;

public class DefaultValue implements TypeVisitor<Value> {
    private final String emptyString = "";

    @Override
    public Value visit(IntType type) {
        return new IntegerValue(0);
    }

    @Override
    public Value visit(MoneyType type) {
        return new MoneyValue(0.00);
    }

    @Override
    public Value visit(NumericType type) {
        return type.accept(this);
    }

    @Override
    public Value visit(BoolType type) {
        return new BooleanValue(false);
    }

    @Override
    public Value visit(StringType type) {
        return new StringValue(emptyString);
    }
}
