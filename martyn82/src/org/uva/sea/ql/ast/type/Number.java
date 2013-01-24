package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Represents a numeric type.
 */
public class Number extends Type {

	@Override
	public <T> T accept( NodeVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
