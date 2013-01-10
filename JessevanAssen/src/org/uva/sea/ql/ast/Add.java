package org.uva.sea.ql.ast;

import org.uva.sea.ql.Visitee;
import org.uva.sea.ql.Visitor;

public class Add extends BinaryExpr implements Visitee {

	public Add(Expr leftExpression, Expr rightExpression) {
		super(leftExpression, rightExpression);
	}

	@Override
	public <ReturnType, ParameterType> ReturnType accept(Visitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}
}
