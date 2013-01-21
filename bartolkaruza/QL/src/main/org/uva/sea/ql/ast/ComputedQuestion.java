package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.grouping.Expr;

public class ComputedQuestion extends Question {

	private Expr expr;
	
	public ComputedQuestion(String name, String label, Expr expr, int lineNumber) {
		super(name, label, lineNumber);
		this.expr = expr;
	}
	
	public Expr getExpr() {
		return expr;
	}

}
