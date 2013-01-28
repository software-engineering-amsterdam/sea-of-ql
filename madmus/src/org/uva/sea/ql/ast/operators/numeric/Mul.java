package org.uva.sea.ql.ast.operators.numeric;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.operators.Binary;

public class Mul extends Binary {

	public Mul(Expr lhs, Expr rhs){
		super(lhs, rhs);
	}
	
}
