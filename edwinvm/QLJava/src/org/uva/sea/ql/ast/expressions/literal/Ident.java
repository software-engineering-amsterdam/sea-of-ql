package org.uva.sea.ql.ast.expressions.literal;

import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.types.Error;
import org.uva.sea.ql.ast.visitors.checkexpr.Visitor;

public class Ident extends Expr {
	private final String _name;

	public Ident(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		if (typeEnv.containsKey(this)) {
			return typeEnv.get(this);
		}
		return new Error();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}