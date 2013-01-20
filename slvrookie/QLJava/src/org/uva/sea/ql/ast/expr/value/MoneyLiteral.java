package org.uva.sea.ql.ast.expr.value;

import org.uva.sea.ql.visitor.Visitor;

public class MoneyLiteral extends Value {

	private final double value;

	public MoneyLiteral(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}

}
