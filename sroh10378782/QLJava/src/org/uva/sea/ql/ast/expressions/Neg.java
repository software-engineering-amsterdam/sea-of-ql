package org.uva.sea.ql.ast.expressions;

public class Neg extends UnaryExpr  {
	private final String operator = "-";
	public Neg(Expr x){
		super(x);
	}
	@Override
	public String getOperator(){
		return this.operator;
	}
}
