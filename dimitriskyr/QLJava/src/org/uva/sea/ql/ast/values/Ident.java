package org.uva.sea.ql.ast.values;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Ident extends Value {
	
	private final String name;
	
	public Ident(String name){
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
