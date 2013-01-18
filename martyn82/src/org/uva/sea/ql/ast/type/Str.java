package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Represents a string type.
 */
public class Str extends Type {
	/**
	 * Constructs a new String type.
	 */
	public Str() {
		super( DataType.STRING );
	}
	
	@Override
	public void accept( NodeVisitor visitor ) {
		visitor.visit( this );
	}
}
