package org.uva.sea.ql.ast.operators.numeric;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.operators.Binary;

public class Div extends Binary {

	public Div(Expr lhs, Expr rhs){
		super(lhs, rhs);
	}
	
}
