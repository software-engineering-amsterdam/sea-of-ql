package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expression.Expression;

public class Computed implements Statement {
	
	private final String label;
	private final Expression expression;
	
	public Computed(String label, Expression expression) {
		this.label = label;
		this.expression = expression;
	}

	public String getLabel() { return label; }
	public Expression getExpression() { return expression; }

	@Override
	public <ReturnType, ParameterType> ReturnType accept(StatementVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}
}
