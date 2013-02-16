package org.uva.sea.ql.visitor.typechecker;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.visitor.evaluator.Error;

public class TypeError extends Error {
	public final static int TYPE_ERROR = 1000;
	public final static int TYPE_MISMATCH = 1001;
	public final static int TYPE_INVALID = 1002;
	public final static int TYPE_UNDEFINED = 1003;

	public TypeError( String message, Node node ) {
		this( TYPE_ERROR, message, node );
	}

	public TypeError( int code, String message, Node node ) {
		super( code, message, node );
	}

	@Override
	public String toString() {
		return String.format(
			"TypeError [%d]: \"%s\" at %s",
			this.getCode(),
			this.getMessage(),
			this.getNode().toString()
		);
	}
}
