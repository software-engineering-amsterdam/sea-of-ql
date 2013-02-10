package org.uva.sea.ql.semanticchecker;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.type.Type;

public interface VisitableExpression<T extends Expr> {
	
	Type accept(ExpressionSemanticVisitor visitor);
}
