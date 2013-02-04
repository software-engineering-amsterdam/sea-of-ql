package org.uva.sea.ql.ast.expr;

public class Pos extends UnaryExpr {

	public Pos(Expr expression) {
		super(expression);
	}

	@Override
	public <ReturnType, ParameterType> ReturnType accept(ExprVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}
}
