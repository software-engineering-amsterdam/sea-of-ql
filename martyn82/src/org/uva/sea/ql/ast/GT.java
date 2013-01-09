package org.uva.sea.ql.ast;

public class GT extends Expr {
	private final Expr e1;
	private final Expr e2;
	
	public GT( Expr e1, Expr e2 ) {
		this.e1 = e1;
		this.e2 = e2;
	}
}
