package org.uva.sea.ql.ast.expression.integer;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Primitive;
import org.uva.sea.ql.ast.expression.compare.ExpressionComparer;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitingException;


public class IntegerPrimitive implements IntegerExpression, Primitive {
	private final int value;
	
	public IntegerPrimitive(int n) {
		this.value = n;
	}
	
	public IntegerPrimitive() {
		this(0);
	}

	@Override
	public void accept(Visitor visitor) throws VisitingException {
		visitor.visit(this);
	}

	@Override
	public int evaluate() {
		return value;
	}
	
	@Override
	public int compareTo(Expression compare_with) {
		ExpressionComparer comparer = new IntegerComparer(this);
		return comparer.compare(compare_with);
	}
}
