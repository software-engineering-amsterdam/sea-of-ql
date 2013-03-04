package org.uva.sea.ql.ast.primaryexpr;

import org.uva.sea.ql.visitor.Visitor;

public class Ident extends Str {

	public Ident(String n) {
		super(n);
	}
	
	public String getName() {
		return getValue();
	}
	
	@Override
	public String toString(){
		return getName();
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
