package ast.expression.value;

import java.util.Map;

import ast.Type;
import ast.expression.Value;
import ast.visitor.Visitor;

public class Str extends Value {

	private final String value;

	public Str(String value) {
		this.value = value;
	}

	public <T> String getValue() {
		return value;
	}
	
	@Override
	public String toString(){
		return this.value;
	}
	
	@Override
	public Type typeOf(Map<ast.type.Ident, Type> typeEnv) {
		return new ast.type.Str();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
