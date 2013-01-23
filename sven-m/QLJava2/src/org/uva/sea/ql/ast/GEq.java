package org.uva.sea.ql.ast;

public class GEq extends Binary implements ASTNode {

	public GEq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

}
