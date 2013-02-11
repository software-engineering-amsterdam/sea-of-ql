package org.uva.sea.ql.visitor.evaluator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observer;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.evaluator.value.Value;

public class Environment {
	private final List<Error> errors;
	private final Map<Ident, Bindable> bindings;

	public Environment() {
		this.errors = new LinkedList<Error>();
		this.bindings = new HashMap<Ident, Bindable>();
	}

	public void clean() {
		this.errors.clear();
		this.bindings.clear();
	}

	public List<Error> getErrors() {
		return this.errors;
	}

	public void addError( Error error ) {
		this.errors.add( error );
	}

	public boolean isDeclared( Ident ident ) {
		return this.bindings.containsKey( ident );
	}

	public Type lookupType( Ident ident ) {
		if ( this.bindings.containsKey( ident ) ) {
			return this.bindings.get( ident ).getType();
		}

		throw new RuntimeException( "Undefined variable: " + ident.getName() );
	}

	public Value lookup( Ident ident ) {
		if ( this.bindings.containsKey( ident ) ) {
			return this.bindings.get( ident ).getValue();
		}

		throw new RuntimeException( "Undefined variable: " + ident.getName() );
	}

	public void declare( Ident ident, Type type ) {
		if ( this.isDeclared( ident ) ) {
			throw new RuntimeException( "Variable " + ident.getName() + " already declared." );
		}

		this.bindings.put( ident, new Bindable( type ) );
	}

	public void assign( Ident ident, Value value ) {
		if ( !this.isDeclared( ident ) ) {
			throw new RuntimeException( "Variable " + ident.getName() + " is undefined." );
		}

		this.bindings.get( ident ).setValue( value );
	}

	public void registerObserver( Ident ident, Observer observer ) {
		this.bindings.get( ident ).addObserver( observer );
	}

	public void notifyObservers( Ident ident ) {
		this.bindings.get( ident ).notifyObservers();
	}
}
