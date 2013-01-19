package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.*;

public class Pos extends Expr {
	private Expr value;
	
	public Pos(Expr value){
		this.value=value;
	}
	
	public Expr getValue() {
		return value;
	}

}
