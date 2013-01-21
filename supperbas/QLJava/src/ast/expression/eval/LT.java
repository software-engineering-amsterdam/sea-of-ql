package ast.expression.eval;

import ast.Expression;
import ast.expression.EvalExpression;

public class LT extends EvalExpression {
	private final int level = 2;

	public LT(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	public int getLevel() {
		return level;
	}

}
