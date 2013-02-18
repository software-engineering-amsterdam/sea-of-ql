package org.uva.sea.ql.ast.operative;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.visitor.IVisitorExpr;

public class Neg extends OperatorUnaryNumeric {
	
	public Neg(Expr operand){
		super(operand);
	}

	@Override
	public <T> T accept(IVisitorExpr<T> visitor) {
		return visitor.visit(this);
	}
	
}
