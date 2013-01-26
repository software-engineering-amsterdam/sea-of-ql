package org.uva.sea.ql.visitor;

import org.uva.sea.ql.visitor.checkers.ExpressionChecker;

public interface Visitable {
	  public boolean accept(ExpressionChecker nodeVisitor);
}
