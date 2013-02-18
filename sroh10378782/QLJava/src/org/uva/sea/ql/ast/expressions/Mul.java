package org.uva.sea.ql.ast.expressions;

public class Mul extends BinaryExpr {
	private final String operator = "*";
	public Mul(Expr lhs, Expr rhs){
		super(lhs,rhs);
	}
	@Override
	public String getOperator(){
		return this.operator;
	}
}
