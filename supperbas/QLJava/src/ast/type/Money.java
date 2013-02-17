package ast.type;

import ast.Type;
import ast.visitor.Visitor;

public class Money extends Numeric {
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToMoney();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
