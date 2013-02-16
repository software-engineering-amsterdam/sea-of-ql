package org.uva.sea.ql.visitor.evaluator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observer;

import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.evaluator.value.Value;

public class Environment {
	private final List<Error> errors;
	private final Map<IdentifierExpression, Bindable> bindings;

	public Environment() {
		this.errors = new LinkedList<Error>();
		this.bindings = new HashMap<IdentifierExpression, Bindable>();
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

	public boolean isDeclared( IdentifierExpression identifier ) {
		return this.bindings.containsKey( identifier );
	}

	public Type lookupType( IdentifierExpression identifier ) {
		if ( this.bindings.containsKey( identifier ) ) {
			return this.bindings.get( identifier ).getType();
		}

		throw new RuntimeException( "Undefined variable: " + identifier.getName() );
	}

	public Value lookup( IdentifierExpression identifier ) {
		if ( this.bindings.containsKey( identifier ) ) {
			return this.bindings.get( identifier ).getValue();
		}

		throw new RuntimeException( "Undefined variable: " + identifier.getName() );
	}

	public void declare( IdentifierExpression identifier, Type type ) {
		if ( this.isDeclared( identifier ) ) {
			throw new RuntimeException( "Variable " + identifier.getName() + " already declared." );
		}

		this.bindings.put( identifier, new Bindable( type ) );
	}

	public void assign( IdentifierExpression identifier, Value value ) {
		if ( !this.isDeclared( identifier ) ) {
			throw new RuntimeException( "Variable " + identifier.getName() + " is not declared." );
		}

		this.bindings.get( identifier ).setValue( value );
	}

	public void registerObserver( IdentifierExpression identifier, Observer observer ) {
		this.bindings.get( identifier ).addObserver( observer );
	}

	public void notifyObservers( IdentifierExpression identifier ) {
		this.bindings.get( identifier ).notifyObservers();
	}
}
