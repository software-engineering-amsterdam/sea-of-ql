package ast.expression.binary;

import ast.Expression;
import ast.expression.BinaryExpression;

public class Div extends BinaryExpression {
	private final int level = 4;
	public Div(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	public int getLevel() {
		return level;
	}

}
