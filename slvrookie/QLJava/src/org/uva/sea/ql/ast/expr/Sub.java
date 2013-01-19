package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.visitor.Visitor;

public class Sub extends BinaryExpr {

	public Sub(Expr result, Expr rhs) {
		super(result, rhs);
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}
	
}
