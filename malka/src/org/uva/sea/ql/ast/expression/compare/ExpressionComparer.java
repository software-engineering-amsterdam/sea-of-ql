package org.uva.sea.ql.ast.expression.compare;

import org.uva.sea.ql.ast.expression.Expression;

public interface ExpressionComparer {
	int compare(Expression e);
}
