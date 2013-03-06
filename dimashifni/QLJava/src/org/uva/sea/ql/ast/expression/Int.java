package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.value.IntegerValue;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.expression.ExpressionVisitor;

import java.util.Map;

public class Int extends Expr {

	private final IntegerValue value;

	public Int(int n) {
		this.value = new IntegerValue(n);
	}

	public IntegerValue getValue() {
		return value;
	}

    @Override
    public Value evaluate(Map<Ident, Value> variables)
    {
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
