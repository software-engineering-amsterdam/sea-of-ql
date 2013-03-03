package org.uva.sea.ql.ast.operative;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.type.BoolType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.util.Environment;

public abstract class OperatorUnaryBoolean extends OperatorUnary {

	public OperatorUnaryBoolean(Expr operand) {
		super(operand);
	}

	@Override
	public Type typeOf(Environment<Ident, Type> env) {
		return new BoolType();
	}

}
