package ast.expressions.eval;

import ast.Expression;
import ast.expressions.EvalExpression;

public class LEq extends EvalExpression {

	public LEq(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

}
