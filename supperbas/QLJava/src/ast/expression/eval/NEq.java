package ast.expression.eval;

import ast.Expression;
import ast.expression.EvalExpression;

public class NEq extends EvalExpression {
	private final int level = 2;

	public NEq(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	public int getLevel() {
		return level;
	}

}
