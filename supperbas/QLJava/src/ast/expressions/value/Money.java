package ast.expressions.value;

import java.util.Map;

import ast.expressions.Value;
import ast.types.Type;

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

}
