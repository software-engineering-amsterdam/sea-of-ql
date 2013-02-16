package org.uva.sea.ql.ast.operative;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Primitive;
import org.uva.sea.ql.interfaces.IVisitorExpr;
import org.uva.sea.ql.util.Environment;

public class Eq extends OperatorBinaryComparative {
	
	public Eq(Expr leftHandOperand, Expr rightHandOperand){
		super(leftHandOperand, rightHandOperand);
	}

	@Override
	public Primitive interpret(Environment env) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public <T> T accept(IVisitorExpr<T> visitor) {
		return visitor.visit(this);
	}
			
}
