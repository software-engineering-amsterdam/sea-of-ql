package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.visitor.INodeVisitor;

public class Money extends Number {
	/**
	 * Constructs a new Money type.
	 */
	public Money() {
		super( DataType.MONEY );
	}
	
	@Override
	public void accept( INodeVisitor visitor ) {
		visitor.visit( this );
	}
}
