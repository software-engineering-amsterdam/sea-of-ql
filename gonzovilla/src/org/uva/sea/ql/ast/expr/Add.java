package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.types.TypeInt;
import org.uva.sea.ql.ast.visitor.VisitorExpressions;

public class Add extends Binary {

	public Add(Expr lhs, Expr rhs) {
		super(lhs,rhs);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new TypeInt();
	}

	@Override
	public <T> T accept(VisitorExpressions<T> visitor) {
		return  visitor.visit(this);
	}
	
}
