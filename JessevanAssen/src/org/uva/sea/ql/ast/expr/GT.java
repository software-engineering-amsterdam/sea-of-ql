package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.Visitor;

public class GT extends BinaryExpr {

	public GT(Expr leftExpression, Expr rightExpression) {
		super(leftExpression, rightExpression);
	}

	@Override
	public <ReturnType, ParameterType> ReturnType accept(Visitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}
}
