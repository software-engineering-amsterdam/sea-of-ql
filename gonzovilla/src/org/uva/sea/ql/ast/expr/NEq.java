package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.types.TypeBool;
import org.uva.sea.ql.ast.visitor.VisitorExpressions;

public class NEq extends Binary {

	public NEq(Expr lhs, Expr rhs) {
			super(lhs, rhs);
	}

	@Override
	public Type typeOf(Map<String, Type> typeEnv) {
		return new TypeBool();
	}

	@Override
	public <T> T accept(VisitorExpressions<T> visitor) {
		return  visitor.visit(this);
	}
	
}
