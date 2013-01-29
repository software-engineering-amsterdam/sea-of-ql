package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.*;

public class Not extends Expr {
	private Expr value;
	
	public Not(Expr value){
		this.value=value;
	}
	
	public Expr getValue() {
		return value;
	}

	
}
