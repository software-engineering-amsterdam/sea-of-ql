package org.uva.sea.ql.ast.operators.logical;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operators.UnaryOperator;

public class Not extends UnaryOperator {

	public Not(Expression operand) {
		super(operand);
	}
	
}