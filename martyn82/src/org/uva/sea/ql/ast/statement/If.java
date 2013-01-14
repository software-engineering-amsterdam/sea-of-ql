package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expression;

/**
 * 
 */
public class If extends Statement {
	private final Expression condition;
	private final Statement body;
	
	/**
	 * Constructs a new IF-statement.
	 * 
	 * @param condition The expression condition.
	 * @param body The statement body.
	 */
	public If( Expression condition, Statement body ) {
		this.condition = condition;
		this.body = body;
	}
}
