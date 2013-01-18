package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.visitor.INodeVisitor;

/**
 * Represents an IF-THEN statement block.
 */
public class If extends Statement {
	/**
	 * Holds the condition of the statement.
	 */
	private final Expression condition;
	
	/**
	 * Holds the if body.
	 */
	private final Statements ifThen;
	
	/**
	 * Holds the else body.
	 */
	private final Statements ifElse;
	
	/**
	 * Constructs a new IF-statement.
	 * 
	 * @param condition The expression condition.
	 * @param ifThen The if-body.
	 * @param ifElse The else-body.
	 */
	public If( Expression condition, Statements ifThen, Statements ifElse ) {
		this.condition = condition;
		this.ifThen = ifThen;
		this.ifElse = ifElse;
	}
	
	/**
	 * Constructs new IF-statement.
	 * 
	 * @param condition The expression condition.
	 * @param ifThen The if-body.
	 */
	public If( Expression condition, Statements ifThen ) {
		this( condition, ifThen, null );
	}
	
	/**
	 * Constructs a new IF-statement without any body statements.
	 * 
	 * @param condition The expression condition.
	 */
	public If( Expression condition ) {
		this( condition, null, null );
	}
	
	public Expression getCondition() {
		return this.condition;
	}
	
	public Statements getIfThen() {
		return this.ifThen;
	}
	
	public Statements getIfElse() {
		return this.ifElse;
	}

	@Override
	public void accept( INodeVisitor visitor ) {
		visitor.visit( this );
	}
}
