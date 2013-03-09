package org.uva.sea.ql.ast.expression.bool.operation.relational;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.string.StringExpression;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitingException;

public class Eq extends BinaryRelationalOperation {
	
	public Eq(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public void accept(Visitor visitor) throws VisitingException {
		visitor.visit(this);
	}
	
	@Override
	public boolean evaluate(){
		/*
		System.out.println("equal");
		if (left_operand instanceof StringExpression) {
			System.out.println("operand: ");
			System.out.println(((StringExpression)left_operand).evaluate());
		} else {
			System.out.println(left_operand.getClass());
		}
		*/
		return left_operand.compareTo(right_operand) == 0;
	}

}
