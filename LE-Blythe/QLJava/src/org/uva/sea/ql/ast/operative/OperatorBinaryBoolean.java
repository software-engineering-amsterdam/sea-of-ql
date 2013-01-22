package org.uva.sea.ql.ast.operative;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.OperatorBinary;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.util.Environment;

public abstract class OperatorBinaryBoolean extends OperatorBinary{

	public OperatorBinaryBoolean(Expr leftHandOperand, Expr rightHandOperand) {
		super(leftHandOperand, rightHandOperand);
	}

	@Override
	public Type typeOf(Environment env) {
		return new Bool();
	}
	
}
