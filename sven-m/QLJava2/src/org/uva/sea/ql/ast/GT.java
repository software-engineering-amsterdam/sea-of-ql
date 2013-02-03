package org.uva.sea.ql.ast;

public class GT extends Binary implements ASTNode {

	public GT(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

}
