package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.TypeVisitor;

/**
 * Represents a String type.
 */
public class StringType extends Type {
	@Override
	public <T> T accept( TypeVisitor<T> visitor ) {
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
