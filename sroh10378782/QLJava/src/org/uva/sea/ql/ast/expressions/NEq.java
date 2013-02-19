package org.uva.sea.ql.ast.expressions;

public class NEq extends BinaryExpr {
	private final String operator = "!=";
	public NEq(Expr lhs, Expr rhs){
		super(lhs,rhs);
	}
	@Override
	public String getOperator(){
		return this.operator;
	}
}
