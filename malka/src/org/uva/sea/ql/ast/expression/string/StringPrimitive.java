package org.uva.sea.ql.ast.expression.string;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Primitive;
import org.uva.sea.ql.ast.expression.compare.ExpressionComparer;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitingException;

public class StringPrimitive implements Primitive, StringExpression {
	private final String value;
	
	public StringPrimitive(String str) {
		this.value = str;
	}
	
	public StringPrimitive() {
		this("");
	}
	
	@Override
	public void accept(Visitor visitor) throws VisitingException {
		visitor.visit(this);
	}

	@Override
	public String evaluate() {
		return value;
	}
	
	@Override
	public int compareTo(Expression compare_with) {
		ExpressionComparer comparer = new StringComparer(this);
		return comparer.compare(compare_with);
	}
}