package org.uva.sea.ql.visitor.evaluator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observer;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.evaluator.value.Value;

/**
 * Represents an evaluation context.
 */
public class Environment {
	/**
	 * Holds the error list.
	 */
	private final List<Error> errors;

	/**
	 * Holds the variable bindings.
	 */
	private final Map<Ident, Bindable> bindings;

	/**
	 * Constructs a new context.
	 */
	public Environment() {
		this.errors = new LinkedList<Error>();
		this.bindings = new HashMap<Ident, Bindable>();
	}

	/**
	 * Cleans the environment by wiping the types, bindings and errors.
	 */
	public void clean() {
		this.errors.clear();
		this.bindings.clear();
	}

	/**
	 * Retrieves the error list.
	 *
	 * @return Errors
	 */
	public List<Error> getErrors() {
		return this.errors;
	}

	/**
	 * Adds an error to the list of errors.
	 *
	 * @param message
	 */
	public void addError( Error error ) {
		this.errors.add( error );
	}

	/**
	 * Determines whether the given identifier is defined.
	 *
	 * @param ident
	 *
	 * @return True if it is defined, false otherwise.
	 */
	public boolean isDeclared( Ident ident ) {
		return this.bindings.containsKey( ident );
	}

	/**
	 * Finds a declared variable for the given identifier and returns its type.
	 *
	 * @param ident
	 *
	 * @return The type of the given identifier.
	 *
	 * @throws RuntimeException If the variable cannot be found.
	 */
	public Type lookupType( Ident ident ) {
		if ( this.bindings.containsKey( ident ) ) {
			return this.bindings.get( ident ).getType();
		}

		throw new RuntimeException( "Undefined variable: " + ident.getName() );
	}

	/**
	 * Finds a declared variable for the given identifier and returns its value.
	 *
	 * @param ident
	 *
	 * @return The value of the given identifier.
	 *
	 * @throws RuntimeException If the variable cannot be found.
	 */
	public Value lookup( Ident ident ) {
		if ( this.bindings.containsKey( ident ) ) {
			return this.bindings.get( ident ).getValue();
		}

		throw new RuntimeException( "Undefined variable: " + ident.getName() );
	}

	/**
	 * Declares a variable for the given identifier and type.
	 *
	 * @param ident
	 * @param type
	 */
	public void declare( Ident ident, Type type ) {
		if ( this.isDeclared( ident ) ) {
			throw new RuntimeException( "Variable " + ident.getName() + " already declared." );
		}

		this.bindings.put( ident, new Bindable( type ) );
	}

	/**
	 * Assigns a value to a variable for the given identifier and value.
	 *
	 * @param ident
	 * @param value
	 */
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
