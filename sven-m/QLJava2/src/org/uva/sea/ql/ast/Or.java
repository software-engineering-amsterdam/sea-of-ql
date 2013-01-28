package org.uva.sea.ql.ast;

public class Or extends Binary implements ASTNode {

	public Or(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

}
