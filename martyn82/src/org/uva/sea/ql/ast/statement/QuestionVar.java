package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.literal.Str;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.StatementVisitor;

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

	/**
	 * Retrieves the type of the declaration.
	 *
	 * @return The type.
	 */
	public Type getType() {
		return this.varDeclaration.getType();
	}

	@Override
	public Ident getIdent() {
		return this.varDeclaration.getIdent();
	}

	@Override
	public <T> T accept( StatementVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
