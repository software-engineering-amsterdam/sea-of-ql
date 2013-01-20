package org.uva.sea.ql.ast.operators.logical;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.operators.UnaryOperator;

public class Not extends UnaryOperator {

	public Not(Expr operand) {
		super(operand);
	}
	
}