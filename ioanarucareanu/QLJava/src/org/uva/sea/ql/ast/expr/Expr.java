package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.semanticchecker.ExpressionSemanticVisitor;
import org.uva.sea.ql.semanticchecker.VisitableExpression;

public abstract class Expr implements ASTNode, VisitableExpression<Expr> {

	@Override
	public void accept(Expr visitableElement, ExpressionSemanticVisitor visitor) {
		
		System.out.println("Default expression visiting. Yield smth");
	}

	
}
