package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.traversal.base.IVisitor;


public class Money extends DataType {
	private double value;

	public Money() { }
	
	
	public Money(final String value) {
		this.value = Double.parseDouble(value);
	}
	
	public Object getValue() {
		return value;
	}

	@Override
	public void accept(final IVisitor visitor) {
		visitor.visit(this);
	}
}
