package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.ITypeVisitor;

/**
 * Represents a numeric type.
 */
public class Number extends Type {
	@Override
	public <T> T accept( ITypeVisitor<T> visitor ) {
		return visitor.visit( this );
	}

	@Override
	public boolean isCompatibleTo( Type type ) {
		return type.isCompatibleToNumber();
	}

	@Override
	public boolean isCompatibleToNumber() {
		return true;
	}

	@Override
	public boolean isCompatibleToInt() {
		return true;
	}

	@Override
	public boolean isCompatibleToMoney() {
		return true;
	}
}
