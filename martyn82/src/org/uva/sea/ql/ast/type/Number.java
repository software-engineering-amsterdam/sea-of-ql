package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.eval.Context;
import org.uva.sea.ql.eval.value.Value;
import org.uva.sea.ql.visitor.INodeVisitor;

/**
 * Represents a numeric type.
 */
public class Number extends Type {

	@Override
	public Value<?> accept( INodeVisitor visitor, Context context ) {
		return visitor.visit( this, context );
	}
}
