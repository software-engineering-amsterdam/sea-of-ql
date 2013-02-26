package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public class Identifier extends Simple {

	private final String name;

	public Identifier(final ICodeLocationInformation codeLocation,
			final String name) {
		super(codeLocation);
		this.name = name;
	}

	@Override
	public <T> T accept(final IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof Identifier) {
			final Identifier identifier = (Identifier) obj;
			return this.name.equals(identifier.getName());
		}
		return false;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
}
