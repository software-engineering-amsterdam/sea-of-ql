package org.uva.sea.ql.ast.value;

import java.math.BigDecimal;

public class Money extends Value {
	
	private java.math.BigDecimal value;
	
	public Money() {
		this.setValue(BigDecimal.valueOf(0.0f));
	}
	
	public Money(BigDecimal initialValue) {
		this.setValue(initialValue);
	}

	public java.math.BigDecimal getValue() {
		return value;
	}

	public void setValue(java.math.BigDecimal value) {
		this.value = value;
	}

}
