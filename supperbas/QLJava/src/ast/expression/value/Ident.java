package ast.expression.value;

import java.util.Map;

import ast.Type;
import ast.expression.Value;
import ast.visitor.Visitor;

public class Ident extends Value {

	private final String value;

	public Ident(String value) {
		this.value = value;
	}

	public String getvalue() {
		return value;
	}

	public String getValue() {
		return value;
	}
	
	@Override
	public String toString(){
		return this.value;
	}
	
	@Override
	public Type typeOf(Map<ast.type.Ident, Type> typeEnv) {
		if (typeEnv.containsKey(this)) {
			return typeEnv.get(this);
		}
		return new ast.type.Undefined(this);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
