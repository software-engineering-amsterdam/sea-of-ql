package org.uva.sea.ql.ast.operators.numeric;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operators.UnaryOperator;

public class Neg extends UnaryOperator {

	public Neg(Expression operand) {
		super(operand);
	}
	
}
