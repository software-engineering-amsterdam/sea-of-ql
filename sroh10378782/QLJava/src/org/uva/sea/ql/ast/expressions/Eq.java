package org.uva.sea.ql.ast.expressions;

public class Eq extends BinaryExpr {
	private final String operator = "==";
	public Eq(Expr lhs, Expr rhs){
		super(lhs,rhs);
	}
	@Override
	public String getOperator(){
		return this.operator;
	}
}
