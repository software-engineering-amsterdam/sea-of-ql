package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class Add extends Binary {

	public Add(Expr left, Expr right) {
		super(left,right) ;
	}

	@Override
	public void accept(ASTNodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
		
	}

	

}
