package ast.expressions.eval;

import ast.Expression;
import ast.expressions.EvalExpression;

public class NEq extends EvalExpression {

	public NEq(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

}
