package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Expr;

public class Computed implements Statement {
	
	private final String label;
	private final Expr expression;
	
	public Computed(String label, Expr expression) {
		this.label = label;
		this.expression = expression;
	}

	public String getLabel() { return label; }
	public Expr getExpression() { return expression; }

	@Override
	public <ReturnType, ParameterType> ReturnType accept(ASTNodeVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}
}
