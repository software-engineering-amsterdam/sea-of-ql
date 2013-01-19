package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.visitor.Visitor;

public class Mul extends BinaryExpr {

	public Mul(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}
	
}
