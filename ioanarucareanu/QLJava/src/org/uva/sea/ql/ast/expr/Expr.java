package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.semanticchecker.ExpressionSemanticVisitor;
import org.uva.sea.ql.semanticchecker.VisitableExpression;

public abstract class Expr implements ASTNode, VisitableExpression<Expr> {

	@Override
	public Type accept(ExpressionSemanticVisitor visitor) {
		
		System.out.println("Default expression visiting. Yield smth");
		return null;
	}
	
	public String getOperator() {
		
		System.out.println("Abstract operator");
		return null;
	}

	
}
