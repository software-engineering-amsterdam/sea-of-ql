package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ASTVisitor;


public class GT extends Binary {

	public GT(Expr result, Expr rhs) {
		super (result, rhs);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
		
	}

}