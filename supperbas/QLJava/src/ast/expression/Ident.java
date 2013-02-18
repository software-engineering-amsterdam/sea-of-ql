package ast.expression;

import java.util.Map;


import ast.Expression;
import ast.Type;
import ast.type.Undefined;

public class Ident extends Expression {

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
	public Type typeOf(Map<Ident, Type> typeEnv) {
		if (typeEnv.containsKey(this)) {
			return typeEnv.get(this);
		}
		return new Undefined();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String typeStr() {
		return null;
	}

}
