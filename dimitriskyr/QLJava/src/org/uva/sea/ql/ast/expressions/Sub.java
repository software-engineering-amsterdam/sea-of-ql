package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Sub extends BinaryExpression{
	
	public Sub (Expr lhs, Expr rhs){
		super(lhs,rhs);
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
