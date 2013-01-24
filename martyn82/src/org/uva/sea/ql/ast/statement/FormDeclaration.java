package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.eval.Environment;
import org.uva.sea.ql.visitor.INodeVisitor;

/**
 * Represents a form declaration node.
 */
public class FormDeclaration extends Statement {
	/**
	 * Holds the identifier node.
	 */
	private final Ident ident;

	/**
	 * Holds the statements body.
	 */
	private final Statements statements;

	/**
	 * Constructs a new form declaration node.
	 *
	 * @param name
	 * @param statements
	 */
	public FormDeclaration( Ident name, Statements statements ) {
		this.ident = name;
		this.statements = statements;
	}

	/**
	 * Retrieves the declaration body.
	 *
	 * @return Declaration body.
	 */
	public Statements getStatements() {
		return this.statements;
	}

	/**
	 * Retrieves the identifier node.
	 *
	 * @return Declaration identifier.
	 */
	public Ident getIdent() {
		return this.ident;
	}

	@Override
	public <T> T accept( INodeVisitor<T> visitor, Environment context ) {
		return visitor.visit( this, context );
	}
}
