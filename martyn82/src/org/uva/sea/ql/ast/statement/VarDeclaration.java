package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.eval.Environment;
import org.uva.sea.ql.visitor.NodeVisitor;

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
	public <T> T accept( NodeVisitor<T> visitor, Environment context ) {
		return visitor.visit( this, context );
	}
}
