package ast.exprs.binary;

import java.util.Map;

import ast.Expr;
import ast.exprs.Binary;
import ast.types.Type;
import ast.visitors.Visitor;

public class Add extends Binary {
	private final int level = 3;

	public Add(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	public int getLevel() {
		return level;
	}

	@Override
	public Type typeOf(Map<ast.types.Ident, Type> typeEnv) {
		return new ast.types.Numeric();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
