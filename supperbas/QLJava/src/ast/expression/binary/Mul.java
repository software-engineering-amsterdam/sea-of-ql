package ast.expression.binary;

import ast.Expression;
import ast.expression.BinaryExpression;

public class Mul extends BinaryExpression {
	private final int level = 4;
	public Mul(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	public int getLevel() {
		return level;
	}

}
