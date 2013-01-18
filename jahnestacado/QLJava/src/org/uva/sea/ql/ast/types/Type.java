package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.ASTNode;


public abstract class Type implements ASTNode {
	
	private String type ;

	public Type(String type) {
		this.type = type ;
	}
	
	public String getType() {
		return type;
	}

}
