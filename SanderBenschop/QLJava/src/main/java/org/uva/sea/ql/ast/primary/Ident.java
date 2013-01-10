package org.uva.sea.ql.ast.primary;

import org.uva.sea.ql.ast.QLExpression;

public final class Ident extends QLExpression {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
