package org.uva.sea.ql.ast.expression.bool;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.Primitive;
import org.uva.sea.ql.ast.expression.Variable;
import org.uva.sea.ql.ast.expression.compare.ExpressionComparer;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitingException;

public class BooleanVariable extends Variable implements BooleanExpression {
	protected BooleanPrimitive bound_primitive;
	
	public BooleanVariable(Identifier id) {
		super(id);
	}
	
	@Override
	public void accept(Visitor visitor) throws VisitingException {
		visitor.visit(this);
	}
	
	@Override
	public boolean evaluate(){
		if (bound_primitive == null) {
			return false;
		} else {
			return bound_primitive.evaluate();
		}
	}
	
	@Override
	protected boolean setPrimitive(Primitive p) {
		boolean correct_type = false;
		if ( p instanceof BooleanPrimitive) {
			bound_primitive = (BooleanPrimitive)p;
			correct_type = true;
		}
		return correct_type;
	}

	@Override
	public int compareTo(Expression compare_with) {
		ExpressionComparer comparer = new BooleanComparer(this);
		return comparer.compare(compare_with);
	}
}
