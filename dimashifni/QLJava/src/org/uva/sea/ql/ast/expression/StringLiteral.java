package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.value.StringValue;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.expression.ExpressionVisitor;

import java.util.Map;

public class StringLiteral extends Expr {
    private final StringValue value;

    public StringLiteral(String value) {
        this.value = new StringValue(value);
    }

    public StringValue getValue()
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
