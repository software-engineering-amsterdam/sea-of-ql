package org.uva.sea.ql.ast.expression.unary.numeric;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.unary.UnaryExpression;

abstract public class UnaryNumericExpression extends UnaryExpression {
	protected UnaryNumericExpression( Expression expression ) {
		super( expression );
	}
}
