package ast.expression.binary;

import ast.Expression;
import ast.expression.BinaryExpression;

public class Sub extends BinaryExpression {
	private final int level = 3;

	public Sub(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	public int getLevel() {
		return level;
	}

}
