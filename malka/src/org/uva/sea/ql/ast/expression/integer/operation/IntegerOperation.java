package org.uva.sea.ql.ast.expression.integer.operation;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.compare.ExpressionComparer;
import org.uva.sea.ql.ast.expression.integer.IntegerComparer;
import org.uva.sea.ql.ast.expression.integer.IntegerExpression;

public abstract class IntegerOperation implements IntegerExpression {
	@Override
	public int compareTo(Expression compare_with) {
		ExpressionComparer comparer = new IntegerComparer(this);
		return comparer.compare(compare_with);
	}
}
