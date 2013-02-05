package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.literal.Str;

/**
 * Represents a question declaration.
 */
abstract public class QuestionDeclaration extends Statement {
	/**
	 * Holds the label node.
	 */
	private final Str label;

	/**
	 * Constructs a new QuestionDeclaration.
	 *
	 * @param label
	 */
	public QuestionDeclaration( Str label ) {
		this.label = label;
	}

	/**
	 * Retrieves the label node.
	 *
	 * @return Label AST node.
	 */
	public Str getLabel() {
		return this.label;
	}

	/**
	 * Retrieves the identifier of the question.
	 *
	 * @return The identifier.
	 */
	abstract public Ident getIdent();
}
