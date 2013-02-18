package org.uva.sea.ql.ast.expressions;

public class LEq extends BinaryExpr {
	private final String operator = ">=";
	public LEq(Expr lhs, Expr rhs){
		super(lhs,rhs);
	}
	@Override
	public String getOperator(){
		return this.operator;
	}
}
