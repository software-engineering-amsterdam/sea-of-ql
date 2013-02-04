package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Pos extends UnaryExpression {
	
	public Pos(Expr value){
		super(value);
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
