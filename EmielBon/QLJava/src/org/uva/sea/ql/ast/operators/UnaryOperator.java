package org.uva.sea.ql.ast.operators;

import org.uva.sea.ql.ast.Expression;

public class UnaryOperator extends Expression {

	protected final Expression operand;
	
	public UnaryOperator(Expression operand) {
		this.operand = operand;
	}
	
}
