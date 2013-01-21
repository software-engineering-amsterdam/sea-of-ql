package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class Pos extends Unary {

	public Pos (Expr x){
		System.out.println("+");
	}

	@Override
	public void accept(ASTNodeVisitor nodeVisitor) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
