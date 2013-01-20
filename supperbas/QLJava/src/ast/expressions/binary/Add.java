package ast.expressions.binary;

import ast.Expression;
import ast.expressions.BinaryExpression;

public class Add extends BinaryExpression {

	public Add(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

}
