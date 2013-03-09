package org.uva.sea.ql.ast.expression.integer;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.compare.CompareException;
import org.uva.sea.ql.ast.expression.compare.ExpressionComparer;

public class IntegerComparer implements ExpressionComparer {
	private IntegerExpression compare_expression;
	
	public IntegerComparer(IntegerExpression compare_expression) {
		this.compare_expression = compare_expression;
	}
	
	@Override
	public int compare(Expression compare_to) {
		if (compare_to instanceof IntegerExpression) {
			Integer integer_compare    = new Integer(compare_expression.evaluate());
			Integer integer_compare_to = new Integer(((IntegerExpression)compare_to).evaluate());
			
			return integer_compare.compareTo(integer_compare_to);
		} else {
			throw new CompareException();
		}
	}
}
