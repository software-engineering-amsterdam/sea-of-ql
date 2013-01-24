package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.eval.Environment;
import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Represents a Boolean type.
 */
public class Bool extends Type {

	@Override
	public <T> T accept( NodeVisitor<T> visitor, Environment context ) {
		return visitor.visit( this, context );
	}
}
