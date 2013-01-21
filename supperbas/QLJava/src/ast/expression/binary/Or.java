package ast.expression.binary;

import ast.Expression;
import ast.expression.BinaryExpression;

public class Or extends BinaryExpression {
	private final int level = 1;

	public Or(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	public int getLevel() {
		return level;
	}

}
