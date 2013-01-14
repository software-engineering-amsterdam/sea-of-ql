package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ASTNodeVisitor;

public class Neg extends UnaryExpr {

	public Neg(Expr expression) {
		super(expression);
	}	

	@Override
	public <ReturnType, ParameterType> ReturnType accept(ASTNodeVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}
}
