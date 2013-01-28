package org.uva.sea.ql.interpreter;

import org.uva.sea.ql.ast.nodevisitor.VisitorResult;

public class BooleanResult implements VisitorResult {
	final private boolean value;

	public boolean getValue() {
		return value;
	}

	public BooleanResult(boolean value) {
		this.value = value;
	}

}
