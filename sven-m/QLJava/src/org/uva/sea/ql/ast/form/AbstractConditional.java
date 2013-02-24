package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.misc.Location;

public abstract class AbstractConditional extends FormElement {
	private final Expr condition;
	private final Body body;
	private final Location startLocation;
	
	public AbstractConditional(Expr condition, Body body,
			Location startLocation)
	{
		this.condition = condition;
		this.body = body;
		this.startLocation = startLocation;
	}
	
	public Expr getCondition() {
		return condition;
	}
	
	public Body getBody() {
		return body;
	}
	
	protected Location getStartLocation() {
		return startLocation;
	}
	
}
