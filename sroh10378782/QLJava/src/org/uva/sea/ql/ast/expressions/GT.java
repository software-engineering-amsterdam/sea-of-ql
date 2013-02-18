package org.uva.sea.ql.ast.expressions;

public class GT extends BinaryExpr{
	private final String operator = ">";
	public GT(Expr lhs, Expr rhs){
		super(lhs,rhs);
	}
	@Override
	public String getOperator(){
		return this.operator;
	}
}
