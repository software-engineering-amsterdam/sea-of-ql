package org.uva.sea.ql.ast.operative;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.visitor.IVisitorExpr;

public class Not extends OperatorUnaryBoolean {
	
	public Not(Expr operand){
		super(operand);
	}

	@Override
	public <T> T accept(IVisitorExpr<T> visitor) {
		return visitor.visit(this);
	}
		
}
