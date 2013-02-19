package org.uva.sea.ql.ast.types;

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

}
