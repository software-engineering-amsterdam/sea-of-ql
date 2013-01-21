package ast.expressions.binary;

import ast.Expression;
import ast.expressions.BinaryExpression;

public class Or extends BinaryExpression {

	public Or(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

}
