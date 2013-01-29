package ast.expression.value;

import java.util.Map;

import ast.expression.Value;
import ast.types.Type;
import ast.visitors.Visitor;

public class Money extends Value {

	private final int value;

	public Money(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}
	
	@Override
	public Type typeOf(Map<ast.types.Ident, Type> typeEnv) {
		return new ast.types.Numeric();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
