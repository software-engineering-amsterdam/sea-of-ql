package org.uva.sea.ql.ast.expression.binary.arithmetic;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.binary.BinaryExpression;

abstract public class ArithmeticExpression extends BinaryExpression {
	public ArithmeticExpression( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}
}
