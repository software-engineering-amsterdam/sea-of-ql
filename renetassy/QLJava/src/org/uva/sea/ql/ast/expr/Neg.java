package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ASTVisitor;



public class Neg extends Unary {

	public Neg(Expr x) {
		super(x);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
		
	}
	
}