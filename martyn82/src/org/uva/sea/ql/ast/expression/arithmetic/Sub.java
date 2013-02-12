package org.uva.sea.ql.ast.expression.arithmetic;

import org.uva.sea.ql.ast.expression.ArithmeticExpression;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Sub extends ArithmeticExpression {
	public Sub( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}

	@Override
	public <T> T accept( ExpressionVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
