package ast.expression.unary;

import ast.Expression;
import ast.expression.UnaryExpression;

public class Neg extends UnaryExpression {
	private final int level = 6;

	public Neg(Expression expr) {
		super(expr);
	}

	public int getLevel() {
		return level;
	}

}
