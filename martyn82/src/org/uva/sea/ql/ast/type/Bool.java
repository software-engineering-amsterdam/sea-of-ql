package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.ITypeVisitor;

/**
 * Represents a Boolean type.
 */
public class Bool extends Type {
	@Override
	public <T> T accept( ITypeVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
