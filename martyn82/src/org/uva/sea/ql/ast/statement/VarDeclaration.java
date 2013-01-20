package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.evaluate.Context;
import org.uva.sea.ql.evaluate.Value;
import org.uva.sea.ql.visitor.INodeVisitor;

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
	private final DataType type;

	/**
	 * Constructs a new variable declaration.
	 *
	 * @param ident
	 * @param type
	 */
	public VarDeclaration( Ident ident, DataType type ) {
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
	public DataType getType() {
		return this.type;
	}

	@Override
	public Value accept( INodeVisitor visitor, Context context ) {
		return visitor.visit( this, context );
	}
}
