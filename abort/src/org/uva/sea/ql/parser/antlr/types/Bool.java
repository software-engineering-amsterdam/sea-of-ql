package org.uva.sea.ql.parser.antlr.types;

import org.uva.sea.ql.ast.Expression;

public class Bool extends Expression {
	private boolean value; 
	
	public Bool(boolean value) {
		this.value = value;
	}
	
	public Object getValue() {
		return value;
	}
}
