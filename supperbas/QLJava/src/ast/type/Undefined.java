package ast.type;

import ast.Type;

public class Undefined extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean isError() {
		return true;
	}
}
