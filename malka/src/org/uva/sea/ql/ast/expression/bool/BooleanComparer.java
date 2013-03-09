package org.uva.sea.ql.ast.expression.bool;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.compare.CompareException;
import org.uva.sea.ql.ast.expression.compare.ExpressionComparer;

public class BooleanComparer implements ExpressionComparer {
	private BooleanExpression compare_expression;
	
	public BooleanComparer(BooleanExpression compare_expression) {
		this.compare_expression = compare_expression;
	}
	
	@Override
	public int compare(Expression compare_to) {
		if (compare_to instanceof BooleanExpression) {
			Boolean boolean_compare    = new Boolean(compare_expression.evaluate());
			Boolean boolean_compare_to = new Boolean(((BooleanExpression)compare_to).evaluate());
			
			return boolean_compare.compareTo(boolean_compare_to);
		} else {
			throw new CompareException();
		}
	}

}
