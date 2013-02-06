package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.StatementVisitor;

/**
 * Represents a variable declaration.
 */
public class VarDeclaration extends Statement {
	/**
	 * Holds the identifier to declare.
	 */
	private final Ident ident;

	/**
	 * Holds the type the identifier will take.
	 */
	private final Type type;

	/**
	 * Constructs a new variable declaration.
	 *
	 * @param ident
	 * @param type
	 */
	public VarDeclaration( Ident ident, Type type ) {
		this.ident = ident;
		this.type = type;
	}

	/**
	 * Retrieves the identifier.
	 *
	 * @return The identifier.
	 */
	public Ident getIdent() {
		return this.ident;
	}

	/**
	 * Retrieves the type.
	 *
	 * @return The type.
	 */
	public Type getType() {
		return this.type;
	}

	@Override
	public <T> T accept( StatementVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
