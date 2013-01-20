package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.visitor.Visitor;

public class LT extends BinaryExpr {

	public LT(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}
	
}
