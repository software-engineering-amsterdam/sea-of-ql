package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.INodeVisitor;

/**
 * Represents a variable declaration.
 */
public class VarDeclaration extends Statement {
	private final Ident ident;
	private final Type type;
	
	public VarDeclaration( Ident ident, Type type ) {
		this.ident = ident;
		this.type = type;
	}
	
	public Ident getIdent() {
		return this.ident;
	}
	
	public Type getType() {
		return this.type;
	}

	@Override
	public void accept( INodeVisitor visitor ) {
		visitor.visit( this );
	}
}
