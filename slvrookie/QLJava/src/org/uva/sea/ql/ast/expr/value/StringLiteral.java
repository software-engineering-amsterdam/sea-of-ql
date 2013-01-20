package org.uva.sea.ql.ast.expr.value;

import org.uva.sea.ql.visitor.Visitor;

public class StringLiteral extends Value {

	private final String value;

	public StringLiteral(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}
	
}
