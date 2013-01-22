package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class Div extends Binary {

	public Div(Expr result, Expr rhs) {
		super(result,rhs) ;
	}

	@Override
	public void accept(ASTNodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
		
	}

}