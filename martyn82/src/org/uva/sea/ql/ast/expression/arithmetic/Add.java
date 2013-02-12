package org.uva.sea.ql.ast.expression.arithmetic;

import org.uva.sea.ql.ast.expression.ArithmeticExpression;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Add extends ArithmeticExpression {
	public Add( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}

	@Override
	public <T> T accept( ExpressionVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
