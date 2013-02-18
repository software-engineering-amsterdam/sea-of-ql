package org.uva.sea.ql.ast.expressions;

public class Pos extends UnaryExpr {
	private final String operator = "+";
	public Pos(Expr x){
		super(x);
	}
	@Override
	public String getOperator(){
		return this.operator;
	}
}
