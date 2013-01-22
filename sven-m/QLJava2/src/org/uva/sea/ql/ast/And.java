package org.uva.sea.ql.ast;

public class And extends Binary implements ASTNode {

	public And(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

}
