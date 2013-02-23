package org.uva.sea.ql.ast.expressions.binary.relational;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.visitors.typechecker.Visitor;

public class GEq extends BinaryRelationalExpression {
	public GEq(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}