package org.uva.sea.ql.ast.nodetypes.primary;

public final class Ident extends NamedPrimaryExpression {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}

    @Override
	public String getName() {
		return name;
	}
}
