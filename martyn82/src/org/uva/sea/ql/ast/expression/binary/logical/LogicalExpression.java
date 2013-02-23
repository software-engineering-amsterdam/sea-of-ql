package org.uva.sea.ql.ast.expression.binary.logical;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.binary.BinaryExpression;

abstract public class LogicalExpression extends BinaryExpression {
	public LogicalExpression( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}
}
