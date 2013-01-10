package org.uva.sea.ql.ast.unary;

import org.uva.sea.ql.ast.QLExpression;

public abstract class UnaryOperationExpression extends QLExpression {
	
	private final QLExpression expression;
	
	public UnaryOperationExpression(QLExpression expression) {
		this.expression = expression;
	}
	
	public QLExpression getExpression() {
		return expression;
	}
}
