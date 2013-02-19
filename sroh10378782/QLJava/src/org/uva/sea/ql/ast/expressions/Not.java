package org.uva.sea.ql.ast.expressions;

public class Not extends UnaryExpr {
	private final String operator = "!";
	public Not(Expr x){
		super(x);
	}
	@Override
	public String getOperator(){
		return this.operator;
	}
}
