package org.uva.sea.ql.ast.expression.bool;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Primitive;
import org.uva.sea.ql.ast.expression.compare.ExpressionComparer;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitingException;


public class BooleanPrimitive implements BooleanExpression, Primitive {
	
	private final boolean value;
	
	public BooleanPrimitive(boolean bool) {
		this.value = bool;
	}
	
	public BooleanPrimitive() {
		this(false);
	}
	
	public boolean evaluate() {
		return value;
	}
	
	@Override
	public void accept(Visitor visitor) throws VisitingException {
		visitor.visit(this);
	}

	@Override
	public int compareTo(Expression compare_with) {
		ExpressionComparer comparer = new BooleanComparer(this);
		return comparer.compare(compare_with);
	}
	
}
