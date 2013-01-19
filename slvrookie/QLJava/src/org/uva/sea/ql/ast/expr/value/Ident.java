package org.uva.sea.ql.ast.expr.value;

import org.uva.sea.ql.visitor.Visitor;

public class Ident extends Value {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}

}
