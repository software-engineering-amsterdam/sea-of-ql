package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.expr.Expr;

public abstract class ConditionalElement extends BodyElement{
	private final Expr condition;
	private final Body body;
	
	public ConditionalElement(Expr condition, Body body) {
		this.condition=condition;
		this.body=body;
	}
	
	public Expr getCondition(){
		return condition;
	}
	
	public Body getIfBody(){
		return body;
	}

}
