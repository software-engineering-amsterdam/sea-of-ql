package org.uva.sea.ql.ast.expression.string;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.compare.CompareException;
import org.uva.sea.ql.ast.expression.compare.ExpressionComparer;

public class StringComparer implements ExpressionComparer {

	private StringExpression compare_expression;
	
	public StringComparer(StringExpression compare_expression) {
		this.compare_expression = compare_expression;
	}
	
	@Override
	public int compare(Expression compare_to) {
		if (compare_to instanceof StringExpression) {
			String string_compare    = new String(compare_expression.evaluate());
			String string_compare_to = new String(((StringExpression)compare_to).evaluate());
			
			return string_compare.compareTo(string_compare_to);
		} else {
			throw new CompareException();
		}
	}

}
