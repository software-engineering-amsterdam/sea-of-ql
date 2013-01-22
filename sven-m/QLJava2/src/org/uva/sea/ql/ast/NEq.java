package org.uva.sea.ql.ast;

public class NEq extends Binary implements ASTNode {

	public NEq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

}
