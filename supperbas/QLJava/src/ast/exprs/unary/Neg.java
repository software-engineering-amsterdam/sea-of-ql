package ast.exprs.unary;

import java.util.Map;

import ast.Expr;
import ast.exprs.Unary;
import ast.types.Type;
import ast.visitors.Visitor;

public class Neg extends Unary {
	private final int level = 6;

	public Neg(Expr expr) {
		super(expr);
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