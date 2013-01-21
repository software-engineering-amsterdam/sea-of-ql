package ast.expression.eval;

import ast.Expression;
import ast.expression.EvalExpression;

public class Eq extends EvalExpression {
	private final int level = 2;

	public Eq(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	public int getLevel() {
		return level;
	}

}
