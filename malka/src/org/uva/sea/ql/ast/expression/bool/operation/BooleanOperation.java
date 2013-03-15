package org.uva.sea.ql.ast.expression.bool.operation;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.bool.BooleanComparer;
import org.uva.sea.ql.ast.expression.bool.BooleanExpression;
import org.uva.sea.ql.ast.expression.compare.ExpressionComparer;

public abstract class BooleanOperation implements BooleanExpression {
	@Override
	public int compareTo(Expression compare_with) {
		ExpressionComparer comparer = new BooleanComparer(this);
		return comparer.compare(compare_with);
	}
}
