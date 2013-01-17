package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.visitor.Visitor;

/**
 * Represents a statement.
 */
public class Statement implements Node {
	/**
	 * Constructs a new Statement instance.
	 */
	public Statement() {
	}

	@Override
	public void accept( Visitor visitor ) {
		visitor.visit( this );
	}
}
