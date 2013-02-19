package org.uva.sea.ql.ast.expressions;

public class LT extends BinaryExpr {
	private final String operator = "<";
	public LT(Expr lhs, Expr rhs){
		super(lhs,rhs);
	}
	@Override
	public String getOperator(){
		return this.operator;
	}
}
