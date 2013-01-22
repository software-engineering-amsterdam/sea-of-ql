package org.uva.sea.ql.ast.operators.numeric;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.operators.Unary;

public class Neg extends Unary {
	
	public Neg(Expr arg) {
		super(arg);
	}
	
}
