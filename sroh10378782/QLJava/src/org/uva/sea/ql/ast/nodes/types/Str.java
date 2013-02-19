package org.uva.sea.ql.ast.nodes.types;

import org.uva.sea.ql.visitor.Visitor;

public class Str extends Type {
	private final String value;
	public Str(String n) {
		this.value = n;
	}

	public String getValue() {
		return value;
	}
	public String toString(){
		return "Str";
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	@Override
	public boolean isStrType(){
		return true;
	}
}
