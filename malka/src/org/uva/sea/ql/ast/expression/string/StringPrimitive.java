package org.uva.sea.ql.ast.expression.string;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitorException;

public class StringPrimitive implements Expression {
	private final String value;
	
	public StringPrimitive(String str) {
		this.value = str;
	}
	
	public String getValue() {
		return this.value;
	}

	@Override
	public void accept(Visitor visitor) throws VisitorException {
		visitor.visit(this);
	}
}
