package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.expression.Expr;

public class AbstractConditional extends AbstractIfThenElse {
	private Expr condition;
	
	public AbstractConditional(Expr condition, Body body) {
		super(body);
		
		this.condition = condition;
	}
	
	public Expr getCondition() {
		return condition;
	}
}
