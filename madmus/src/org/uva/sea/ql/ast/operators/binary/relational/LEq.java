package org.uva.sea.ql.ast.operators.binary.relational;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.operators.Binary;

public class LEq extends Binary {
	
	public LEq(Expr lhs, Expr rhs){
		super(lhs, rhs);
	}

}
