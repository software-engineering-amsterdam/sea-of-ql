package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.visitor.Visitorinterface;

public abstract class Question extends Statement {

	@Override 
	public void accept(Visitorinterface visitor) {
		visitor.visit(this);		
	}
}
