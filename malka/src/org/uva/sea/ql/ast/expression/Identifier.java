package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitorException;


public class Identifier implements Expression {
	
	private final String name;
	
	public Identifier(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void accept(Visitor visitor) throws VisitorException {
		visitor.visit(this);
	}
	
}
