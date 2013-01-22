package org.uva.sea.ql.ast;

import java.util.List;

import org.uva.sea.ql.ast.expr.Expr;

public class IfStatement extends FormUnit {

	private Expr expression;
	private List<FormUnit> formUnits;
	
	public IfStatement(Expr expression, List<FormUnit> formUnits) {
		this.expression = expression;
		this.formUnits = formUnits;
	}

	public Expr getExpression() {
		return expression;
	}

	public List<FormUnit> getFormUnits() {
		return formUnits;
	}

}
