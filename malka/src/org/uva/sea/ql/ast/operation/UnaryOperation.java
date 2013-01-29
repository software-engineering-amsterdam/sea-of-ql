package org.uva.sea.ql.ast.operation;

import org.uva.sea.ql.ast.Expression;

public interface UnaryOperation extends Operation {
	public Expression getOperand();
}
