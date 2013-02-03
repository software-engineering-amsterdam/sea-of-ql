package org.uva.sea.ql.ast;

public abstract class Unary extends Expr implements ASTNode {
	protected final Expr op;
	
	public Unary(Expr op) {
		this.op = op;
	}
	
	public Expr getOp() {
		return op;
	}
}
