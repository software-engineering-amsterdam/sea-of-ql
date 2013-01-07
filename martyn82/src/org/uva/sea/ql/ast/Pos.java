package org.uva.sea.ql.ast;

public class Pos extends Expr {
	private final Expr e;
	
	public Pos( Expr e ) {
		this.e = e;
	}
}
