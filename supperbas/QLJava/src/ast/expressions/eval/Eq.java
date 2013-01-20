package ast.expressions.eval;

import ast.Expression;
import ast.expressions.EvalExpression;

public class Eq extends EvalExpression {

	public Eq(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

}
