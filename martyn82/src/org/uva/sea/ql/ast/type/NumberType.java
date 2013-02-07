package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.TypeVisitor;

/**
 * Represents a numeric type.
 */
public class NumberType extends Type {
	@Override
	public <T> T accept( TypeVisitor<T> visitor ) {
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

	@Override
	public String toString() {
		return "Number";
	}
}
