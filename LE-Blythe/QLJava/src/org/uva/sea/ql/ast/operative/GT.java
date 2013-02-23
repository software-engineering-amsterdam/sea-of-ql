package org.uva.sea.ql.ast.operative;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.visitor.IVisitorExpr;

public class GT extends OperatorBinaryComparative{
	
	public GT(Expr leftHandOperand, Expr rightHandOperand){
		super(leftHandOperand, rightHandOperand);
	}

	@Override
	public <T> T accept(IVisitorExpr<T> visitor) {
		return visitor.visit(this);
	}
	
}
