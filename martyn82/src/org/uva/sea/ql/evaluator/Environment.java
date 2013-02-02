package org.uva.sea.ql.evaluator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.evaluator.value.Value;

/**
 * Represents an evaluation context.
 */
public class Environment {
	/**
	 * Holds the declared variables.
	 */
	private final Map<Ident, Type> types;

	/**
	 * Holds the bound variables.
	 */
	private final Map<Ident, Value> bindings;

	/**
	 * Holds the error list.
	 */
	private final List<Error> errors;

	/**
	 * Constructs a new context.
	 */
	public Environment() {
		this.types = new HashMap<Ident, Type>();
		this.bindings = new HashMap<Ident, Value>();
		this.errors = new LinkedList<Error>();
	}

	/**
	 * Cleans the environment by wiping the types, bindings and errors.
	 */
	public void clean() {
		this.types.clear();
		this.bindings.clear();
		this.errors.clear();
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
		return this.types.containsKey( ident );
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
		if ( this.types.containsKey( ident ) ) {
			return this.types.get( ident );
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
			return this.bindings.get( ident );
		}

		throw new RuntimeException( "Undefined variable: " + ident.getName() );
	}

	/**
	 * Declares a variable for the given identifier and type.
	 *
	 * @param ident
	 * @param type
	 */
	public void declareType( Ident ident, Type type ) {
		if ( this.isDeclared( ident ) ) {
			throw new RuntimeException( "Variable " + ident.getName() + " already declared." );
		}

		this.types.put( ident, type );
	}

	/**
	 * Declares a variable for the given identifier and value.
	 *
	 * @param ident
	 * @param value
	 */
	public void declareVariable( Ident ident, Value value ) {
		this.bindings.put( ident, value );
	}
}
