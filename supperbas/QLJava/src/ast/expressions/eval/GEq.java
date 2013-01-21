package ast.expressions.eval;

import ast.Expression;
import ast.expressions.EvalExpression;

public class GEq extends EvalExpression {

	public GEq(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

}
