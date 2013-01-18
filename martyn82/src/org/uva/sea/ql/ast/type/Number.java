package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.visitor.INodeVisitor;

/**
 * 
 */
public class Number extends Type {
	/**
	 * Constructs a new Number type.
	 * 
	 * @param type
	 */
	public Number( DataType type ) {
		super( type );
	}
	
	@Override
	public void accept( INodeVisitor visitor ) {
		visitor.visit( this );
	}

}
