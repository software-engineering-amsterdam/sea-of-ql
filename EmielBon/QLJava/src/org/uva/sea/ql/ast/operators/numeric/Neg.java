package org.uva.sea.ql.ast.operators.numeric;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.operators.UnaryOperator;

public class Neg extends UnaryOperator {

	public Neg(Expr operand) {
		super(operand);
	}
	
}
