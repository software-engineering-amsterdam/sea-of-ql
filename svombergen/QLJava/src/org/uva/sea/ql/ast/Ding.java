package org.uva.sea.ql.ast;

public class Ding {
	
	protected Expr name;
	protected Expr rest;

	public Ding(Expr x, Expr s){
		name = x;
		rest = s;
	}
}
