package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.visitor.Visitor;

public final class Pos extends UnaryExpr {

	public Pos(Expr arg) {
		super(arg);
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}
	
}
