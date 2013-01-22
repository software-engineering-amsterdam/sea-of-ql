package ast.exprs.eval;

import java.util.Map;

import ast.Expr;
import ast.exprs.Eval;
import ast.types.Type;
import ast.visitors.Visitor;

public class Eq extends Eval {
	private final int level = 2;

	public Eq(Expr lhs, Expr rhs) {
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
