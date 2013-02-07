package org.uva.sea.ql.ast.expr.primary;

import java.util.Map;

import org.uva.sea.ql.type.IntegerType;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.IExpressionVisitor;


public class Int extends Primary<Integer> {

	private final int value;

	public Int(int value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return "Int";
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new IntegerType();
	}
	
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
