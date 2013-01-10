package org.uva.sea.ql.ast;

public class Computed extends FormElement {
	
	private final String label;
	private final Expr expression;
	
	public Computed(String label, Expr expression) {
		this.label = label;
		this.expression = expression;
	}

	public String getLabel() { return label; }
	public Expr getExpression() { return expression; }
	
}
