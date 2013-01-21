package ast.expression.binary;

import ast.Expression;
import ast.expression.BinaryExpression;

public class And extends BinaryExpression {
	private final int level = 1;

	public And(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	public int getLevel() {
		return level;
	}

}
