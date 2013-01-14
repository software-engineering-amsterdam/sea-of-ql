package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.visitor.NodeVisitor;

public class Int extends Expr {

	private final int value;
	private final int lineNumber;

	public Int(Integer value, int lineNumber) {
		this.value = value;
		this.lineNumber = lineNumber;
	}

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

	public int getValue() {
		return value;
	}

	public int getLineNumber() {
		return lineNumber;
	}

}
