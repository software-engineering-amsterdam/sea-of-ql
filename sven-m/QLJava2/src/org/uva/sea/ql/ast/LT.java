package org.uva.sea.ql.ast;

public class LT extends Binary implements ASTNode {

	public LT(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

}
