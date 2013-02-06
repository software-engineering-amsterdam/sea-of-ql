package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.TypeVisitor;

/**
 * Represents an Error type.
 */
public class Undefined extends Type {
	@Override
	public <T> T accept( TypeVisitor<T> visitor ) {
		return null;
	}

	@Override
	public boolean isCompatibleTo( Type type ) {
		return false;
	}

	@Override
	public String toString() {
		return "Undefined";
	}
}
