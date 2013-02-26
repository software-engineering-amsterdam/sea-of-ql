package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.types.TypeError;
import org.uva.sea.ql.ast.visitor.VisitorExpressions;

public class Ident extends Expr {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public Type typeOf(Map<String, Type> typeEnv) {
		if (typeEnv.containsKey(getName())) {
			return typeEnv.get(getName());
			}
			return new TypeError();
	}

	@Override
	public <T> T accept(VisitorExpressions<T> visitor) {
		return  visitor.visit(this);
	}
	
}