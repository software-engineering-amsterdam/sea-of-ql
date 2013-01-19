package org.uva.sea.ql.ast.operations;

import org.uva.sea.ql.ast.Expr;

public class BinaryOperation extends Expr {
	protected Expr m_operand_left;
	protected Expr m_operand_right;
	
	public BinaryOperation(Expr left, Expr right) {
		this.m_operand_left  = left;
		this.m_operand_right = right;
	}
}
