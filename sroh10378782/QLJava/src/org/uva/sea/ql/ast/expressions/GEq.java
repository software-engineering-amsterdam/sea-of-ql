package org.uva.sea.ql.ast.expressions;

public class GEq extends BinaryExpr {
	private final String operator = ">=";
	public GEq(Expr lhs, Expr rhs){
		super(lhs,rhs);
	}
	@Override
	public String getOperator(){
		return this.operator;
	}
}
