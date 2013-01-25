package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Represents an Error type.
 */
public class Error extends Type {
	@Override
	public <T> T accept( NodeVisitor<T> visitor ) {
		return null;
	}
}
