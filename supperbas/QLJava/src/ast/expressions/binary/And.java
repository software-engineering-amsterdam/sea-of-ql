package ast.expressions.binary;

import ast.Expression;
import ast.expressions.BinaryExpression;

public class And extends BinaryExpression {

	public And(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

}
