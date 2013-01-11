package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.Visitor;

public class Pos extends UnaryExpr {

	public Pos(Expr expression) {
		super(expression);
	}

	@Override
	public <ReturnType, ParameterType> ReturnType accept(Visitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}
}
