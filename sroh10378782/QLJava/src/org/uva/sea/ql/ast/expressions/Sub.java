package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.visitor.Visitor;

public class Sub extends BinaryExpr {
	private final String operator = "-";
	public Sub(Expr lhs, Expr rhs){
		super(lhs,rhs);
	}
	@Override
	public String getOperator(){
		return this.operator;
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
