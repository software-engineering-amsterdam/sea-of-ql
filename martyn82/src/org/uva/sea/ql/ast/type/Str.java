package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.ITypeVisitor;

/**
 * Represents a String type.
 */
public class Str extends Type {
	@Override
	public <T> T accept( ITypeVisitor<T> visitor ) {
		return visitor.visit( this );
	}

	@Override
	public boolean isCompatibleToStr() {
		return true;
	}

	@Override
	public boolean isCompatibleTo( Type type ) {
		return type.isCompatibleToStr();
	}

	@Override
	public String toString() {
		return "String";
	}
}
