package org.uva.sea.ql.ast.operators.binary.relational;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.operators.Binary;

public class Eq extends Binary {

	public Eq(Expr lhs, Expr rhs){
		super(lhs, rhs);
	}
		
}
