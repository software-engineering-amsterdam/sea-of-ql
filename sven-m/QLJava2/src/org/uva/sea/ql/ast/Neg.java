package org.uva.sea.ql.ast;

public class Neg extends Unary implements ASTNode {

	public Neg(Expr op) {
		super(op);
	}

}
