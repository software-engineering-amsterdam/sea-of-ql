package ast.type;

import ast.Type;
import ast.visitor.Visitor;

public class Ident extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
