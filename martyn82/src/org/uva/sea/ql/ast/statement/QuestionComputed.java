package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.literal.Str;
import org.uva.sea.ql.visitor.IStatementVisitor;

/**
 * Represents a computed question declaration.
 */
public class QuestionComputed extends QuestionDeclaration {
	/**
	 * Holds the assignment for the question.
	 */
	private final Assignment assignment;

	/**
	 * Constructs a new computed question.
	 *
	 * @param label
	 * @param assignment
	 */
	public QuestionComputed( Str label, Assignment assignment ) {
		super( label );
		this.assignment = assignment;
	}

	/**
	 * Retrieves the assignment of the question.
	 *
	 * @return The assignment.
	 */
	public Assignment getAssignment() {
		return this.assignment;
	}

	/**
	 * Retrieves the expression of the assignment.
	 *
	 * @return The expression.
	 */
	public Expression getExpression() {
		return this.assignment.getExpression();
	}

	@Override
	public Ident getIdent() {
		return this.assignment.getIdent();
	}

	@Override
	public <T> T accept( IStatementVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
