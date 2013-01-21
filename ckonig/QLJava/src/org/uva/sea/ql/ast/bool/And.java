package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.Expr;

public class And extends BinaryBoolOperator{
	public static final String str = "&&";
	
	public And(Expr left, Expr right){
		super(left, right);
	}

	
}
