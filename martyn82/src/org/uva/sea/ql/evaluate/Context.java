package org.uva.sea.ql.evaluate;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.value.Value;
import org.uva.sea.ql.ast.type.Type;

public class Context {
	private final Context parent;
	private final Map<Ident, Value> variables;
	private final Map<Ident, Type> types;

	public Context( Context parent ) {
		this.parent = parent;
		this.variables = new HashMap<Ident, Value>();
		this.types = new HashMap<Ident, Type>();
	}

	public Context() {
		this( null );
	}

	public boolean isRoot() {
		return this.parent == null;
	}

	public Value find( Ident ident ) {
		if ( this.variables.containsKey( ident ) ) {
			return this.variables.get( ident );
		}

		if ( !this.isRoot() ) {
			return this.parent.find( ident );
		}

		throw new RuntimeException( "Undefined variable: " + ident.getName() );
	}

	public Type findType( Ident ident ) {
		if ( this.types.containsKey( ident ) ) {
			return this.types.get( ident );
		}

		if ( !this.isRoot() ) {
			return this.parent.findType( ident );
		}

		throw new RuntimeException( "Undefined variable: " + ident.getName() );
	}

	public void defineVariable( Ident ident, Value value ) {
		this.variables.put( ident, value );
	}
}
