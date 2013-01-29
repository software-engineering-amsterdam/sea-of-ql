package org.uva.sea.ql.ast;

public class Not extends Unary implements ASTNode {

	public Not(Expr op) {
		super(op);
	}

}
