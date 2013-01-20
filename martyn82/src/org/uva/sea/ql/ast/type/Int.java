package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.evaluate.Context;
import org.uva.sea.ql.evaluate.Value;
import org.uva.sea.ql.visitor.INodeVisitor;

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
	public Value accept( INodeVisitor visitor, Context context ) {
		return visitor.visit( this, context );
	}
}
