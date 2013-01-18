package org.uva.sea.ql.ast.expr.value;

import org.uva.sea.ql.visitor.NodeVisitor;

public class Int extends Value {

	private final int value;

	public Int() {
		value = 0;
	}

	public Int(String value) {
		this.value = Integer.parseInt(value);
	}

	public int getValue() {
		return value;
	}

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

}
