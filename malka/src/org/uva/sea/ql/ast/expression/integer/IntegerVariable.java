package org.uva.sea.ql.ast.expression.integer;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.Primitive;
import org.uva.sea.ql.ast.expression.Variable;
import org.uva.sea.ql.ast.expression.compare.ExpressionComparer;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitingException;

public class IntegerVariable extends Variable implements IntegerExpression {
	protected IntegerPrimitive bound_primitive;
	
	public IntegerVariable(Identifier id) {
		super(id);
	}
	
	@Override
	public void accept(Visitor visitor) throws VisitingException {
		visitor.visit(this);
	}
	
	@Override
	public int evaluate() {
		if (bound_primitive == null)
			return 0;
		else
			return bound_primitive.evaluate();
	}

	@Override
	protected boolean setPrimitive(Primitive p) {
		boolean correct_type = false;
		if ( p instanceof IntegerPrimitive) {
			bound_primitive = (IntegerPrimitive)p;
			correct_type = true;
		}
		return correct_type;
	}

	@Override
	public int compareTo(Expression compare_with) {
		ExpressionComparer comparer = new IntegerComparer(this);
		return comparer.compare(compare_with);
	}
}
