package org.uva.sea.ql.ast;

public class LEq extends Binary implements ASTNode {

	public LEq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

}
