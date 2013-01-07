package org.uva.sea.ql.ast;

public class Not extends Expr {
	private final Expr e;
	
	public Not( Expr e ) {
		this.e = e;
	}
}
