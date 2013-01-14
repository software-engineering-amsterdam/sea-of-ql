package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ASTNode;

public abstract class Expr implements ASTNode {
	
	protected Expr lhs;
	protected Expr rhs;
	private int lineNumber;
	
	public Expr() {
		
	}
	
	public Expr(Expr lhs, Expr rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public Expr getLhs() {
		return lhs;
	}
	
	public Expr getRhs() {
		return rhs;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

}
