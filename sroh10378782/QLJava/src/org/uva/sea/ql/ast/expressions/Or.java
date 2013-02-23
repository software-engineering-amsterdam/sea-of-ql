package org.uva.sea.ql.ast.expressions;

public class Or extends BinaryExpr {
	private final String operator = "||";
	public Or(Expr lhs, Expr rhs){
		super(lhs,rhs);
	}
	@Override
	public String getOperator(){
		return this.operator;
	}
}
