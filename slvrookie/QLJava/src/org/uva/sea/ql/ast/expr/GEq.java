package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.visitor.Visitor;

public class GEq extends BinaryExpr {

	public GEq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}
	
}
