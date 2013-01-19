package org.uva.sea.ql.ast.operators;

import org.uva.sea.ql.ast.Expr;

public class UnaryOperator extends Expr {

	protected final Expr operand;
	
	public UnaryOperator(Expr operand) {
		this.operand = operand;
	}
	
}
