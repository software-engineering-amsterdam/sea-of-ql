package ast.expression.unary;

import ast.Expression;
import ast.expression.UnaryExpression;

public class Pos extends UnaryExpression {
	private final int level = 6;

	public Pos(Expression expr) {
		super(expr);
	}

	public int getLevel() {
		return level;
	}

}
