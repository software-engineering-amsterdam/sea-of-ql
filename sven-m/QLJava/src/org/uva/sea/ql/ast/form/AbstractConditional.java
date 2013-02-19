package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.Location;
import org.uva.sea.ql.ast.expressions.Expr;

public abstract class AbstractConditional extends AbstractIfThenElse {
	private Expr condition;
	
	public AbstractConditional(Expr condition, Body body, Location location) {
		super(body, location);
		
		this.condition = condition;
	}
	
	public Expr getCondition() {
		return condition;
	}
}
