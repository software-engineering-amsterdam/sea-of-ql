package org.uva.sea.ql.ast.operators.relational;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.operators.Binary;

public class GT extends Binary {

	public GT(Expr lhs, Expr rhs){
		super(lhs, rhs);
	}
	
}
