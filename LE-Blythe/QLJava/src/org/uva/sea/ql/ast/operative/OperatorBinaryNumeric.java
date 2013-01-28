package org.uva.sea.ql.ast.operative;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.OperatorBinary;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.util.Environment;

public abstract class OperatorBinaryNumeric extends OperatorBinary{

	public OperatorBinaryNumeric(Expr leftHandOperand, Expr rightHandOperand) {
		super(leftHandOperand, rightHandOperand);
	}

	
	@Override
	public Type typeOf(Environment env) {
		return new Numeric();
	}

}
