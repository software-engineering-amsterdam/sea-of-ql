package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.literal.Str;
import org.uva.sea.ql.visitor.IStatementVisitor;

/**
 * Represents a question declaration.
 */
public class QuestionVar extends QuestionDeclaration {
	/**
	 * Holds the var declaration of the question.
	 */
	private final VarDeclaration varDeclaration;

	/**
	 * Constructs a new question declaration.
	 *
	 * @param label
	 * @param varDeclaration
	 */
	public QuestionVar( Str label, VarDeclaration varDeclaration ) {
		super( label );
		this.varDeclaration = varDeclaration;
	}

	/**
	 * Retrieves the var declaration of the question.
	 *
	 * @return The declaration.
	 */
	public VarDeclaration getVarDeclaration() {
		return this.varDeclaration;
	}

	@Override
	public <T> T accept( IStatementVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
