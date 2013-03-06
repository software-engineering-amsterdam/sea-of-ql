package org.uva.sea.ql.ast.operative;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.type.NumericType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.util.Environment;

public abstract class OperatorBinaryNumeric extends OperatorBinary{

	public OperatorBinaryNumeric(Expr leftHandOperand, Expr rightHandOperand) {
		super(leftHandOperand, rightHandOperand);
	}

	
	@Override
	public Type typeOf(Environment<Ident, Type> env) {
		return new NumericType();
	}

}
