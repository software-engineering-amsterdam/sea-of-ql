package org.uva.sea.ql.ast;

public abstract class UnaryExpr extends Expr {
	protected Expr expression;
	
	public UnaryExpr(Expr result){
		expression = result;
	}
	
	@Override
	public String toString(){
		return this.getType() + expression;
	}
	
}
