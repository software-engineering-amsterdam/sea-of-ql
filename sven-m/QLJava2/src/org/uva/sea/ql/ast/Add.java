package org.uva.sea.ql.ast;

public class Add extends Binary implements ASTNode {

	public Add(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

}
