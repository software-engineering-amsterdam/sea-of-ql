package ast.exprs.value;

import java.util.Map;

import ast.exprs.Value;
import ast.types.Type;
import ast.visitors.Visitor;

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
		if (typeEnv.containsKey(this)) {
			return typeEnv.get(this);
		}
		return new ast.types.Error(this);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
