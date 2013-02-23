package org.uva.sea.ql.ast.operative;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.util.Environment;

public abstract class OperatorBinaryComparative extends OperatorBinary {

	public OperatorBinaryComparative(Expr leftHandOperand, Expr rightHandOperand) {
		super(leftHandOperand, rightHandOperand);
	}

	@Override
	public Type typeOf(Environment env) {
		return new Bool();
	}
	
}
