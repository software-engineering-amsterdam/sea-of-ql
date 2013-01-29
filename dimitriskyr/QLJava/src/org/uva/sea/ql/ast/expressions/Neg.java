package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.*;

public class Neg extends Expr {
	private Expr value;
	
	public Neg(Expr value){
		this.value=value;
	}
	
	public Expr getValue() {
		return value;
	}

	
}
