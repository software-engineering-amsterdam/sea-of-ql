package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ExprTypeChecker;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;

public class LEq extends Binary {

	public LEq(Expr result, Expr rhs) {
		super(result, rhs);
	}

	@Override
	public boolean accept(ExprTypeChecker visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type isOfType(Map<String, Type> typeEnv) {
		return new BoolType();
	}

}
