package org.uva.sea.ql.ast;

import java.util.List;

public class If extends FormElement {
	
	private final Expr condition;
	private final List<FormElement> ifBody;
	private final List<FormElement> elseBody;
	
	public If(Expr condition, List<FormElement> ifBody, List<FormElement> elseBody) {
		this.condition = condition;
		this.ifBody = ifBody;
		this.elseBody = elseBody;
	}
	
	public Expr getCondition() { return condition; }
	public List<FormElement> getIfBody() { return ifBody; }
	public List<FormElement> getElseBody() { return elseBody; }
	
}
