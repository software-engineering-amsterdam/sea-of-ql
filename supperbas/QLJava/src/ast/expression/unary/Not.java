package ast.expression.unary;

import ast.Expression;
import ast.expression.UnaryExpression;

public class Not extends UnaryExpression {
	private final int level = 6;

	public Not(Expression expr) {
		super(expr);
	}

	public int getLevel() {
		return level;
	}

}
