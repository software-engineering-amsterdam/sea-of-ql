package org.uva.sea.ql.ast;

public class Neg extends Expr {
	private final Expr e;
	
	public Neg( Expr e ) {
		this.e = e;
	}
}
