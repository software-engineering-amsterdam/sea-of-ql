package ast.expressions.value;

import java.util.Map;

import ast.expressions.Value;
import ast.types.Type;

public class Int extends Value {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}
	
	@Override
	public Type typeOf(Map<ast.types.Ident, Type> typeEnv) {
		return new ast.types.Int();
	}

}
