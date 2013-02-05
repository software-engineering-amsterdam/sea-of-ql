package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.visitor.Visitor;

public class LT extends BinaryExpression{

	public LT (Expr lhs, Expr rhs){
		super(lhs,rhs);
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
