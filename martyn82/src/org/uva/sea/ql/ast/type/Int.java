package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.visitor.Visitor;

/**
 * Represents an integer type.
 */
public class Int extends Number {
	/**
	 * Constructs a new Int type.
	 */
	public Int() {
		super( DataType.INTEGER );
	}
	
	@Override
	public void accept( Visitor visitor ) {
		visitor.visit( this );
	}
}
