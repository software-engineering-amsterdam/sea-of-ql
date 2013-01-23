package org.uva.sea.ql.ast;

public class Eq extends Binary implements ASTNode {

	public Eq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

}
