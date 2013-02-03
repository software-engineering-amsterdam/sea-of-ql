package org.uva.sea.ql.runtime;

import org.uva.sea.ql.ast.expressions.Expression;

public interface IExpressionEvaluator {
	Value getValue(Expression expr);
}
