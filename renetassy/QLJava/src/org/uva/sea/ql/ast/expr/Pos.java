package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.ExprTypeChecker;
import org.uva.sea.ql.ast.types.NumericType;
import org.uva.sea.ql.ast.types.Type;

public class Pos extends Unary {
	public Pos(Expr x) {
		super(x);
	}

	@Override
	public boolean accept(ExprTypeChecker visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type isOfType(Map<String, Type> typeEnv) {
		return new NumericType();
	}

}
