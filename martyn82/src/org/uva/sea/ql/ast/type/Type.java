package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.visitor.Visitor;

/**
 * Represents a type value.
 */
public class Type implements Node {
	private final DataType type;
	
	public Type( DataType type ) {
		this.type = type;
	}
	
	public DataType getType() {
		return this.type;
	}
	
	@Override
	public void accept( Visitor visitor ) {
		visitor.visit( this );
	}
}
