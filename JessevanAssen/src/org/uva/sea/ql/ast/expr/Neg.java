package org.uva.sea.ql.ast.expr;

public class Neg extends UnaryExpr {

	public Neg(Expr expression) {
		super(expression);
	}	

	@Override
	public <ReturnType, ParameterType> ReturnType accept(ExprVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}
}
