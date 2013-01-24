package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.eval.Environment;
import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Represents a String type.
 */
public class Str extends Type {

	@Override
	public <T> T accept( NodeVisitor<T> visitor, Environment context ) {
		return visitor.visit( this, context );
	}
}
