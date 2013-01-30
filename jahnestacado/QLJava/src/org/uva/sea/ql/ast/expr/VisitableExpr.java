package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.visitor.IExprVisitor;

public interface VisitableExpr {
	  public abstract <T> T accept(IExprVisitor<T> nodeVisitor);
}
