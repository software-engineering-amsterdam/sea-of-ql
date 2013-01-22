package ast.expressions.value;

import java.util.Map;

import ast.expressions.Value;
import ast.types.Type;

public class Ident extends Value {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public Type typeOf(Map<ast.types.Ident, Type> typeEnv) {
		return new ast.types.Ident();
	}

}
