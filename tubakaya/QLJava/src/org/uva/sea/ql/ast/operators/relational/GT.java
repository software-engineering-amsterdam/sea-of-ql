package org.uva.sea.ql.ast.operators.relational;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionTypeVisitor;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.operators.RelationalOperator;
import org.uva.sea.ql.ast.types.Type;

public class GT extends RelationalOperator {

	public GT(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public Type accept(ExpressionTypeVisitor visitor) {
		return visitor.visit(this);
	}
}
