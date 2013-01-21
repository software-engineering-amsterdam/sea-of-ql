package org.uva.sea.ql.ast.operators.relational;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.operators.Binary;

public class NEq extends Binary {

	public NEq(Expr lhs, Expr rhs){
		super(lhs, rhs);
	}
	
}
