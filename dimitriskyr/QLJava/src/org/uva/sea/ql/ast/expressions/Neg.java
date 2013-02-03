package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Neg extends UnaryExpression {
	
	public Neg(Expr value){
	super(value);
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
