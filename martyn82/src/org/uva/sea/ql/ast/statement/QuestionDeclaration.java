package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.literal.Str;
import org.uva.sea.ql.visitor.IStatementVisitor;

/**
 * Represents a question declaration.
 */
public class QuestionDeclaration extends Statement {
	/**
	 * Holds the name node.
	 */
	private final Str name;

	/**
	 * Holds the declaration node.
	 */
	private final Statement statement;

	/**
	 * Holds the identifier.
	 */
	private final Ident ident;

	/**
	 * Constructs a new question declaration node.
	 *
	 * @param name
	 * @param declaration
	 */
	public QuestionDeclaration( Str name, VarDeclaration declaration ) {
		this.name = name;
		this.statement = declaration;
		this.ident = declaration.getIdent();
	}

	/**
	 * Constructs a new question declaration.
	 *
	 * @param name
	 * @param assignment
	 */
	public QuestionDeclaration( Str name, Assignment assignment ) {
		this.name = name;
		this.statement = assignment;
		this.ident = assignment.getIdent();
	}

	/**
	 * Retrieves the name node.
	 *
	 * @return Name AST node.
	 */
	public Str getName() {
		return this.name;
	}

	/**
	 * Retrieves the identifier.
	 *
	 * @return The identifier AST node.
	 */
	public Ident getIdent() {
		return this.ident;
	}

	/**
	 * Retrieves the declaration node.
	 *
	 * @return Declaration AST node.
	 */
	public Statement getDeclaration() {
		return this.statement;
	}

	@Override
	public <T> T accept( IStatementVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
