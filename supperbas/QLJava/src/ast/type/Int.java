package ast.type;

import ast.Type;

public class Int extends Numeric {
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToInt();
	}
}
