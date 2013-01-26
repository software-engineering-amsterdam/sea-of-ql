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
}
