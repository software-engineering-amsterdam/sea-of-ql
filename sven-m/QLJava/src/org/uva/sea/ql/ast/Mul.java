package org.uva.sea.ql.ast;

public class Mul extends Binary implements ASTNode {

	public Mul(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

}
