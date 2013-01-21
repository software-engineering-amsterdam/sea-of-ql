package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class GEq extends Binary {

	public GEq(Expr result, Expr rhs) {
		super(result,rhs) ;
	}

	@Override
	public void accept(ASTNodeVisitor nodeVisitor) {
		// TODO Auto-generated method stub
		
	}

}
