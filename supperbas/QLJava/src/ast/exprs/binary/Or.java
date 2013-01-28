package ast.exprs.binary;

import java.util.Map;

import ast.Expr;
import ast.exprs.Binary;
import ast.types.Type;
import ast.visitors.Visitor;

public class Or extends Binary {
	private final int level = 1;

	public Or(Expr lhs, Expr rhs) {
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
