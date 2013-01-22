package org.uva.sea.ql.ast.operation;

import org.uva.sea.ql.ast.Expression;

public interface BinaryOperation extends Operation {
	public Expression getLeftOperand();
	public Expression getRightOperand();
}
