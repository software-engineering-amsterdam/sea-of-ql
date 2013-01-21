package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.*;

public class Ident extends Type {
	
	private final String name;
	
	public Ident(String name){
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

}
