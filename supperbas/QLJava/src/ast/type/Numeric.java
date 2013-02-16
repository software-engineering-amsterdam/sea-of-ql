package ast.type;

import ast.Type;
import ast.visitor.Visitor;

public class Numeric extends Type {
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToNumeric();
	}

	public boolean isCompatibleToInt() {
		return true;
	}

	public boolean isCompatibleToMoney() {
		return true;
	}

	public boolean isCompatibleToNumeric() {
		return true;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}