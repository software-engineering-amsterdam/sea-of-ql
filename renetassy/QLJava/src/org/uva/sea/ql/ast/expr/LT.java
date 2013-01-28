package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ASTVisitor;



public class LT extends Binary {

	public LT(Expr result, Expr rhs) {
		super(result, rhs);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
		
	}

}
