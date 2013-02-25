package org.uva.sea.ql.runtime;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.runtime.values.Value;

public interface IExpressionEvaluator {
	Value getValue(Expression expr);
}
