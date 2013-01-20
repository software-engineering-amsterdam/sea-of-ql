package org.uva.sea.ql.ast.expr.value;

import org.uva.sea.ql.visitor.NodeVisitor;

public class TextString extends Value {

	private String value;

	public TextString() {
		this.setValue("");
	}

	public TextString(String initialValue) {
		this.value = initialValue;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

}
