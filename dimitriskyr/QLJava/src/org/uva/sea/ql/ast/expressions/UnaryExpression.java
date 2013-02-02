package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.visitor.Visitor;

public class UnaryExpression extends Expr {
	private Expr value;
	
	public UnaryExpression(Expr value){
		this.value=value;
	}
	
	public Expr getValue() {
		return value;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
}