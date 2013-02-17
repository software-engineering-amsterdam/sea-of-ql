package org.uva.sea.ql.ast.expression.operation;

import org.uva.sea.ql.ast.expression.Expression;

public interface BinaryOperation {
	public Expression getLeftOperand();
	public Expression getRightOperand();
}
