package org.uva.sea.ql.ast;

public class Div extends Binary implements ASTNode {

	public Div(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

}
