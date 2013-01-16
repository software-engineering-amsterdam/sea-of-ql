package org.uva.sea.ql.ast.expr.value;

import org.uva.sea.ql.visitor.NodeVisitor;

public class Bool extends Value {

	private Boolean value;

	public Bool() {
		value = false;
	}

	public Bool(String initialValue) {
		this.value = new Boolean(initialValue);
	}

	public Boolean getValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

}
