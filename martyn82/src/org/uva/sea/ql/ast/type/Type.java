package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.ast.INode;
import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Represents a type value.
 */
public class Type implements INode {
	private final DataType type;
	
	public Type( DataType type ) {
		this.type = type;
	}
	
	public DataType getType() {
		return this.type;
	}
	
	@Override
	public void accept( NodeVisitor visitor ) {
		visitor.visit( this );
	}
}
