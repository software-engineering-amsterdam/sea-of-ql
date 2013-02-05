package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Not extends UnaryExpression {
	
	public Not(Expr value){
		super (value);
	}
		
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
