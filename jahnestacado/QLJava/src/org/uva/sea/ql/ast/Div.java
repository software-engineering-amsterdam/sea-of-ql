package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.Expr;
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
