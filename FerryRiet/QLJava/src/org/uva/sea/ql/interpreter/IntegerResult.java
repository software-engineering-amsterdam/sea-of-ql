package org.uva.sea.ql.interpreter;

import org.uva.sea.ql.ast.nodevisitor.VisitorResult;

public class IntegerResult implements VisitorResult {
	final private int value;

	public int getValue() {
		return value;
	}

	public IntegerResult(int value) {
		this.value = value;
	}
}