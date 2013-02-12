package org.uva.sea.ql.ast.expression.unary.logical;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.unary.UnaryExpression;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class NotExpression extends UnaryExpression {
	public NotExpression( Expression expression ) {
		super( expression );
	}

	@Override
	public <T> T accept( ExpressionVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
