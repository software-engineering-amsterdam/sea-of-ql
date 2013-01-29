package ast.expression.value;

import java.util.Map;

import ast.expression.Value;
import ast.type.Type;
import ast.visitor.Visitor;

public class Money extends Value {

	private final int value;

	public Money(int n) {
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
		return new ast.type.Numeric();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
