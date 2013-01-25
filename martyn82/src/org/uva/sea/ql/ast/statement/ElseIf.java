package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.INode;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Represents an ElseIf block.
 */
public class ElseIf implements INode {
	private final Expression condition;
	private final Statements body;

	/**
	 * Constructs a new ElseIf node.
	 *
	 * @param condition
	 * @param body
	 */
	public ElseIf( Expression condition, Statements body ) {
		this.condition = condition;
		this.body = body;
	}

	public Expression getCondition() {
		return this.condition;
	}

	public Statements getBody() {
		return this.body;
	}

	@Override
	public <T> T accept( NodeVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
