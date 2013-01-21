package ast.expression.eval;

import ast.Expression;
import ast.expression.EvalExpression;

public class LEq extends EvalExpression {
	private final int level = 2;

	public LEq(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	public int getLevel() {
		return level;
	}

}
