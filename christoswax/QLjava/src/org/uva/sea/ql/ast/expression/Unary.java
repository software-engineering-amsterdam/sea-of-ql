package org.uva.sea.ql.ast.expression; 
import org.uva.sea.ql.ast.*;

public class Unary extends Expr {
	private Expr argument;

	public Unary(Expr argument){
		this.argument=argument;
	}
	public Expr getArgument(){
		return argument;
	}
}