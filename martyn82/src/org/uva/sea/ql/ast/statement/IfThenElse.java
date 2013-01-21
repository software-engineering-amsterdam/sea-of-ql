package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.eval.Context;
import org.uva.sea.ql.visitor.INodeVisitor;

/**
 * Represents an IF-THEN statement block.
 */
public class IfThenElse extends Statement {
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
	public IfThenElse( Expression condition, Statements ifThen, Statements ifElse ) {
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
	public IfThenElse( Expression condition, Statements ifThen ) {
		this( condition, ifThen, null );
	}

	/**
	 * Constructs a new IF-statement without any body statements.
	 *
	 * @param condition The expression condition.
	 */
	public IfThenElse( Expression condition ) {
		this( condition, null, null );
	}

	/**
	 * Retrieves the condition of the IF.
	 *
	 * @return The condition.
	 */
	public Expression getCondition() {
		return this.condition;
	}

	/**
	 * Retrieves the THEN body.
	 *
	 * @return The body of the IF.
	 */
	public Statements getIfThen() {
		return this.ifThen;
	}

	/**
	 * Retrieves the ELSE-body.
	 *
	 * @return The body of the ELSE.
	 */
	public Statements getIfElse() {
		return this.ifElse;
	}

	@Override
	public <T> T accept( INodeVisitor<T> visitor, Context context ) {
		return visitor.visit( this, context );
	}
}
