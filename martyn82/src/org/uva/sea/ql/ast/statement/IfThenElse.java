package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Represents an IF-THEN statement block.
 */
public class IfThenElse extends Statement {
	/**
	 * Holds the condition of the statement.
	 */
	private final Expression condition;

	/**
	 * Holds the body of the IF.
	 */
	private final Statements ifBody;

	/**
	 * Holds the ELSE-IFS.
	 */
	private final ElseIfs elseIfs;

	/**
	 * Holds the ELSE.
	 */
	private final Else elseBody;

	/**
	 * Constructs a new IF-statement.
	 *
	 * @param condition
	 * @param ifBody
	 * @param elseIfs
	 * @param elseBody
	 */
	public IfThenElse( Expression condition, Statements ifBody, ElseIfs elseIfs, Else elseBody ) {
		this.condition = condition;
		this.ifBody = ifBody;
		this.elseIfs = elseIfs;
		this.elseBody = elseBody;
	}

	/**
	 * Constructs a new IF-THEN-ELSE.
	 *
	 * @param condition
	 * @param ifBody
	 * @param elseIfs
	 */
	public IfThenElse( Expression condition, Statements ifBody, ElseIfs elseIfs ) {
		this( condition, ifBody, elseIfs, null );
	}

	/**
	 * Constructs a new IF-THEN-ELSE.
	 *
	 * @param condition
	 * @param ifBody
	 * @param elseBody
	 */
	public IfThenElse( Expression condition, Statements ifBody, Else elseBody ) {
		this( condition, ifBody, new ElseIfs(), elseBody );
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
	public Statements getIfBody() {
		return this.ifBody;
	}

	/**
	 * Retrieves the else-ifs.
	 *
	 * @return THe ELSE-IFs.
	 */
	public ElseIfs getElseIfs() {
		return this.elseIfs;
	}

	/**
	 * Retrieves the ELSE.
	 *
	 * @return The ELSE.
	 */
	public Else getElse() {
		return this.elseBody;
	}

	/**
	 * Determines whether an IF-body is present.
	 *
	 * @return True if the IF-body is present, false otherwise.
	 */
	public boolean hasIfBody() {
		return this.ifBody != null;
	}

	/**
	 * Determines whether this statement has one or more ELSE-IF statements.
	 *
	 * @return True if there are one or more ELSE-IFs, false otherwise.
	 */
	public boolean hasElseIfs() {
		return this.elseIfs.size() > 0;
	}

	/**
	 * Determines whether this statement has a single ELSE-statement.
	 *
	 * @return True if there is an ELSE statement, false otherwise.
	 */
	public boolean hasElse() {
		return this.elseBody != null;
	}

	@Override
	public <T> T accept( NodeVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
