package org.uva.sea.ql.ast.expression.logical;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.LogicalExpression;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Or extends LogicalExpression {
	public Or( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}

	@Override
	public <T> T accept( ExpressionVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}