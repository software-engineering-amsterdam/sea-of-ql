package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.visitor.Visitor;

public class Not extends UnaryExpr {

	public Not(Expr arg) {
		super(arg);
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}
	
}
