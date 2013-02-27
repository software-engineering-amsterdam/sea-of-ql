package org.uva.sea.ql.ast.nodes.types;

import org.uva.sea.ql.visitor.Visitor;

public class Ident extends Type {

	private final String identifier;
	
	public Ident(String name) {
		this.identifier = name;
	}
	
	public String getValue() {
		return this.identifier;
	}
	
	public String toString(){
		return "Ident";
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	@Override
	public boolean isIdentType(){
		return true;
	}
}
