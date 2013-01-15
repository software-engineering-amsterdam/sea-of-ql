package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.visitor.Visitor;

/**
 * Represents an IF-THEN statement block.
 */
public class If extends Statement {
	/**
	 * Holds the condition of the statement.
	 */
	private final Expression condition;
	
	/**
	 * Holds the statement body.
	 */
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
	
	public Expression getCondition() {
		return this.condition;
	}
	
	public Statement getBody() {
		return this.body;
	}

	@Override
	public void accept( Visitor visitor ) {
		visitor.visit( this );
	}
}
