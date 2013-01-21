package org.uva.sea.ql.ast.expr.value;

import java.math.BigDecimal;

import org.uva.sea.ql.visitor.NodeVisitor;

public class Money extends Value {

	private BigDecimal value;

	public Money() {
		this.value = BigDecimal.valueOf(0.0f);
	}

	public Money(String initialValue) {
		this.value = new BigDecimal(initialValue);
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

}
