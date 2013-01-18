package org.uva.sea.ql.ast.operations;

import org.uva.sea.ql.ast.Expr;

public class UnaryOperation extends Expr {
	protected Expr m_operand;
	
	public UnaryOperation(Expr operand) {
		this.m_operand = operand;
	}
}
