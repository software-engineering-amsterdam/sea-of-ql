package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Represents a boolean type.
 */
public class Bool extends Type {
	/**
	 * Constructs a new Bool type.
	 */
	public Bool() {
		super( DataType.BOOLEAN );
	}

	@Override
	public void accept( NodeVisitor visitor ) {
		visitor.visit( this );
	}
}
