package org.uva.sea.ql.ast.expr.values;

import java.util.Map;

import org.uva.sea.ql.IExprVisitor;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Type;

public class Int extends Value {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}

	@Override
	public <T> T accept(IExprVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type isOfType(Map<String, Type> typeEnv) {
		return new IntType();
	}
}
