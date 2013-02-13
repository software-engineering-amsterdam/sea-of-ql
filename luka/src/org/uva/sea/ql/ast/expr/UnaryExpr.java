package org.uva.sea.ql.ast.expr;

public abstract class UnaryExpr extends Expr{
	protected final Expr expr;
	
	protected UnaryExpr(Expr expr){
		this.expr = expr;
	}
	
	public Expr getExpr(){
		return this.expr;
	}
	
	@Override
	public String toString() {
		return "Unary: "+ this.getClass().toString()+" "+expr.toString();
	}
}
