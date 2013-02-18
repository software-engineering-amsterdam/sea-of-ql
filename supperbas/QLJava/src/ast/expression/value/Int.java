package ast.expression.value;

import java.util.Map;

import ast.Type;
import ast.expression.Ident;
import ast.expression.Value;
import ast.expression.Visitor;

public class Int extends Value<Integer> {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public Integer getValue() {
		return value;
	}
	
	@Override
	public String toString(){
		return String.valueOf(this.value);
	}
	
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new ast.type.Int();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
