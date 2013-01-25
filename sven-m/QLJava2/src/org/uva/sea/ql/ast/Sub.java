package org.uva.sea.ql.ast;

public class Sub extends Binary implements ASTNode {

	public Sub(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

}
