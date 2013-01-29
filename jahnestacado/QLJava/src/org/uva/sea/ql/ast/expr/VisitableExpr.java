package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.visitor.checkers.ExpressionChecker;

public interface VisitableExpr {
	  public boolean accept(ExpressionChecker nodeVisitor);
}
