package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Ident extends Expression {
	private final String name;

	public Ident( String name ) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public boolean equals( Object object ) {
		if ( !( object instanceof Ident ) ) {
			return false;
		}
		return this.name.equals( ( (Ident) object ).name );
	}

	@Override
	public <T> T accept( ExpressionVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
