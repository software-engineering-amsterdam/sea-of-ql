package org.uva.sea.ql.ast.operative;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.OperatorUnary;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.util.Environment;

public abstract class OperatorUnaryNumeric extends OperatorUnary {

	public OperatorUnaryNumeric(Expr operand) {
		super(operand);
	}

	@Override
	public Type typeOf(Environment env) {
		return new Numeric();
	}

}
