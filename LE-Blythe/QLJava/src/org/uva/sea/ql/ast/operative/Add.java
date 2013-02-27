package org.uva.sea.ql.ast.operative;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.IVisitorExpr;

public class Add extends OperatorBinaryNumeric {

	public Add(Expr leftHandOperand, Expr rightHandOperand) {
		super(leftHandOperand, rightHandOperand);
	}

	@Override
	public <T> T accept(IVisitorExpr<T> visitor) {
		return visitor.visit(this);
	}
	
}
