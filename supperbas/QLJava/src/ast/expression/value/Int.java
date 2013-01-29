package ast.expression.value;

import java.util.Map;

import ast.Type;
import ast.expression.Value;
import ast.visitor.Visitor;

public class Int extends Value {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public <T> int getValue() {
		return value;
	}
	
	@Override
	public String toString(){
		return String.valueOf(this.value);
	}
	
	@Override
	public Type typeOf(Map<ast.type.Ident, Type> typeEnv) {
		return new ast.type.Int();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
