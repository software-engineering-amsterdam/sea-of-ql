package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.types.TypeInt;
import org.uva.sea.ql.ast.visitor.VisitorExpressions;

public class Pos extends Unary {

	public Pos(Expr x) {
		super(x);
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
