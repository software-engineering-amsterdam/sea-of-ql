package org.uva.sea.ql.ast.conditionals;

import java.util.List;

import org.uva.sea.ql.ast.base.*;
import org.uva.sea.ql.ast.form.Statement;

/**
 * Represents a base type of If statement in QL.
 * 
 * @author J. Dijkstra
 */
public abstract class IfStatement extends Statement {
	/**
	 * Condition for the if statement.
	 */
	private final Expression condition;
	/**
	 * Form statements displayed on a successful condition.
	 */
	private final List<Statement> successStatements;

	/**
	 * Constructor.
	 * 
	 * @param condition
	 *            condition for the if statement
	 * @param successStatements
	 *            form statements displayed on a successful condition
	 * @param syntaxPosition
	 *            the original position of the expression in the input syntax
	 */
	protected IfStatement(final Expression condition, final List<Statement> successStatements,
			final SyntaxPosition syntaxPosition) {
		super(syntaxPosition);

		this.condition = condition;
		this.successStatements = successStatements;
	}

	/**
	 * Retrieve condition.
	 * 
	 * @return condition
	 */
	public final Expression getCondition() {
		return condition;
	}

	/**
	 * Retrieves form statements displayed on a successful condition.
	 * 
	 * @return form statements
	 */
	public final List<Statement> getSuccessStatements() {
		return successStatements;
	}

}
