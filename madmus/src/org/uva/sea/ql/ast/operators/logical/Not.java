package org.uva.sea.ql.ast.operators.logical;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.operators.Unary;

public class Not extends Unary {

	public Not(Expr arg) {
		super(arg);
	}
	
}
