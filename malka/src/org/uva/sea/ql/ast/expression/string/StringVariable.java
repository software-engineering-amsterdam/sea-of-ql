package org.uva.sea.ql.ast.expression.string;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.Primitive;
import org.uva.sea.ql.ast.expression.Variable;
import org.uva.sea.ql.ast.expression.compare.ExpressionComparer;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitingException;

public class StringVariable extends Variable implements StringExpression{
	protected StringPrimitive bound_primitive;
	
	public StringVariable(Identifier id) {
		super(id);
	}
	
	void bind(StringPrimitive bound_primitive) {
		super.bind(bound_primitive);
	}
	
	@Override
	public void accept(Visitor visitor) throws VisitingException {
		visitor.visit(this);
	}

	@Override
	public String evaluate() {
		if (bound_primitive == null)
			return "";
		else
			return bound_primitive.evaluate();
	}
	
	@Override
	protected boolean setPrimitive(Primitive p) {
		boolean correct_type = false;
		if ( p instanceof StringPrimitive) {
			bound_primitive = (StringPrimitive)p;
			correct_type = true;
		}
		return correct_type;
	}
	
	@Override
	public int compareTo(Expression compare_with) {
		ExpressionComparer comparer = new StringComparer(this);
		return comparer.compare(compare_with);
	}
}
