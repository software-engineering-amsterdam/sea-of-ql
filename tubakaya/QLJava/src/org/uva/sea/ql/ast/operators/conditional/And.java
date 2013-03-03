package org.uva.sea.ql.ast.operators.conditional;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionTypeVisitor;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.operators.ConditionalOperator;
import org.uva.sea.ql.ast.types.Type;

public class And extends ConditionalOperator {

	public And(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public Type accept(ExpressionTypeVisitor visitor) {
		return visitor.visit(this);
	}
}
