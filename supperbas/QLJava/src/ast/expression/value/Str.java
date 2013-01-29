package ast.expression.value;

import java.util.Map;

import ast.expression.Value;
import ast.types.Type;
import ast.visitors.Visitor;

public class Str extends Value {

	private final String name;

	public Str(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public Type typeOf(Map<ast.types.Ident, Type> typeEnv) {
		return new ast.types.Str();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
