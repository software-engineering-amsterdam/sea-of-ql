package org.uva.sea.ql.semanticchecker;

import org.uva.sea.ql.ast.expr.Expr;

public interface VisitableExpression<T extends Expr> {
	
	ReturnType accept(ExpressionSemanticVisitor visitor);
}
