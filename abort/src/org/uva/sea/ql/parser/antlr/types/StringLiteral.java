package org.uva.sea.ql.parser.antlr.types;

import org.uva.sea.ql.ast.Expression;

public class StringLiteral extends Expression {
	private String value;
	
	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return value;
	}
	
	public StringLiteral(String string) {
		this.value = string;
	}

}
