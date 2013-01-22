package org.uva.sea.ql.ast;

import java.util.List;

import org.uva.sea.ql.ast.expr.Expr;

public class IfStatement extends FormUnit {

	private Expr condition;
	private List<FormUnit> body;
	
	public IfStatement(Expr condition, List<FormUnit> body) {
		this.condition = condition;
		this.body = body;
	}

	public Expr getCondition() {
		return condition;
	}

	public List<FormUnit> getBody() {
		return body;
	}

}
