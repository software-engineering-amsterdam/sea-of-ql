package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.checkers.ElementChecker;

public class IfThenElse extends ConditionalElement {

	private final Body elseBody;

	public IfThenElse(Expr condition, Body ifBody, Body elseBody) {
		super(condition,ifBody);
		this.elseBody=elseBody;
	}

	@Override
	public void accept(ElementChecker qlElement) {
			qlElement.visit(this);
	}
	
	public Body getElseBody(){
		return elseBody;
	}

	

}
