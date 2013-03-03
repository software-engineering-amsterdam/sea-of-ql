package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.value.BooleanValue;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.expression.ExpressionVisitor;

import java.util.Map;

public class Bool extends Expr {
    private final BooleanValue value;

    public Bool(Boolean value) {
        this.value = new BooleanValue(value);
    }

    public BooleanValue getValue()
    {
        return this.value;
    }

    @Override
    public Value evaluate(Map<Ident, Value> variables) {
        return value;
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Type getType() {
        return this.value.getType();
    }
}
