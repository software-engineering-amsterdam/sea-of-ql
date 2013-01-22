package ast.exprs.value;

import java.util.Map;

import ast.exprs.Value;
import ast.types.Type;
import ast.visitors.Visitor;

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

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
