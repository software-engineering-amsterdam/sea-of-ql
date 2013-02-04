package ast.expression.unary;

import java.util.Map;

import ast.Expression;
import ast.Type;
import ast.expression.Unary;
import ast.visitor.Visitor;

public class Pos extends Unary {
	private final int level = 6;

	public Pos(Expression expr) {
		super(expr);
	}

	public int getLevel() {
		return level;
	}
	
	@Override
	public Type typeOf(Map<ast.type.Ident, Type> typeEnv) {
		return new ast.type.Numeric();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
