package org.uva.sea.ql.ast.expression.unary.logical;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.unary.UnaryExpression;

abstract public class UnaryLogicalExpression extends UnaryExpression {
	protected UnaryLogicalExpression( Expression expression ) {
		super( expression );
	}
}
