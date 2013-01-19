package org.uva.sea.ql.ast.types;

import java.math.BigDecimal;

import org.uva.sea.ql.ast.traversal.base.IVisitor;


public class Money extends DataType {
	private final BigDecimal value;	
	
	public Money(final String value) {
		this.value = new BigDecimal(value);
	}
	
	public BigDecimal getValue() {
		return value;
	}

	@Override
	public void accept(final IVisitor visitor) {
		visitor.visit(this);
	}
}
