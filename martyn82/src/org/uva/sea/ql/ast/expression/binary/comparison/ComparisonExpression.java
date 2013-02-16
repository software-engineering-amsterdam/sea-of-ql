package org.uva.sea.ql.ast.expression.binary.comparison;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.binary.BinaryExpression;

abstract public class ComparisonExpression extends BinaryExpression {
	protected ComparisonExpression( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}
}
