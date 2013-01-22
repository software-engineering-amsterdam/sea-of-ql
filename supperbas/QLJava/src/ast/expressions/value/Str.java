package ast.expressions.value;

import java.util.Map;

import ast.expressions.Value;
import ast.types.Type;

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

}
