package org.uva.sea.ql.typechecker;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.Environment;

public class TypeEnvironment extends Environment {
	private final Map<IdentifierExpression, Type> types;

	public TypeEnvironment() {
		super();

		this.types = new HashMap<IdentifierExpression, Type>();
	}

	public Type lookupType( IdentifierExpression identifier ) {
		if ( this.types.containsKey( identifier ) ) {
			return this.types.get( identifier );
		}

		throw new RuntimeException( "Undefined variable: " + identifier.getName() );
	}

	public void declare( IdentifierExpression identifier, Type type ) {
		if ( this.isDeclared( identifier ) ) {
			throw new RuntimeException( "Variable " + identifier.getName() + " already declared." );
		}

		this.types.put( identifier, type );
	}

	public boolean isDeclared( IdentifierExpression identifier ) {
		return this.types.containsKey( identifier );
	}
}
