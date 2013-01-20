package ast.expressions.eval;

import ast.Expression;
import ast.expressions.EvalExpression;

public class GT extends EvalExpression {

	public GT(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

}
