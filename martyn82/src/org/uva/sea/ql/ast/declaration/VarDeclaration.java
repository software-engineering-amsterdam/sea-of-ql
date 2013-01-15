package org.uva.sea.ql.ast.declaration;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.Visitor;

/**
 * Represents a variable declaration.
 */
public class VarDeclaration extends Expression {
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
	public void accept( Visitor visitor ) {
//		visitor.visit( this );
	}
}
