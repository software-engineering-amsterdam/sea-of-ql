package ast.expressions.eval;

import ast.Expression;
import ast.expressions.EvalExpression;

public class LT extends EvalExpression {

	public LT(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

}
