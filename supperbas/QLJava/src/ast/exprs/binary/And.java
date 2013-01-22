package ast.exprs.binary;

import java.util.Map;

import ast.Expr;
import ast.exprs.Binary;
import ast.types.Type;
import ast.visitors.Visitor;

public class And extends Binary {
	private final int level = 1;

	public And(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	public int getLevel() {
		return level;
	}

	@Override
	public Type typeOf(Map<ast.types.Ident, Type> typeEnv) {
		return new ast.types.Bool();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
