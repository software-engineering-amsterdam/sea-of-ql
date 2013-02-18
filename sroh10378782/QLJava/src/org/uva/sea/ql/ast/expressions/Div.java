package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.visitor.Visitable;
import org.uva.sea.ql.visitor.Visitor;

public class Div extends BinaryExpr implements Visitable {
	private final String operator = "/";
	public Div(Expr lhs, Expr rhs){
		super(lhs,rhs);
	}
	@Override
	public String getOperator(){
		return this.operator;
	}
	@Override
	public boolean isDivExpression(){
		return true;
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
