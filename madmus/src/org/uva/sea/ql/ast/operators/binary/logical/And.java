package org.uva.sea.ql.ast.operators.binary.logical;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.operators.Binary;

public class And extends Binary {
	
	public And(Expr lhs, Expr rhs){
		super(lhs, rhs);
	}
	
}