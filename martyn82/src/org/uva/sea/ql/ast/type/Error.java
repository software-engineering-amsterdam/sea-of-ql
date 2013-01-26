package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.ITypeVisitor;

/**
 * Represents an Error type.
 */
public class Error extends Type {
	@Override
	public <T> T accept( ITypeVisitor<T> visitor ) {
		return null;
	}
}
