package org.uva.sea.ql.eval;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.type.Type;

/**
 * Represents an evaluation context.
 */
public class Environment {
	/**
	 * Holds the declared variables.
	 */
	private final Map<Ident, Type> types;

	/**
	 * Holds the error list.
	 */
	private final List<Error> errors;

	/**
	 * Constructs a new context.
	 */
	public Environment() {
		this.types = new HashMap<Ident, Type>();
		this.errors = new LinkedList<Error>();
	}

	/**
	 * Retrieves the declared types.
	 *
	 * @return The declared types.
	 */
	public Map<Ident, Type> getTypes() {
		return this.types;
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
		if ( this.types.containsKey( ident ) ) {
			return true;
		}

		return false;
	}

	/**
	 * Finds a declared variable for the given identifier and returns it.
	 *
	 * @param ident
	 *
	 * @return The variable to find.
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
	 * Declares a variable value for the given identifier and value.
	 *
	 * @param ident
	 * @param value
	 */
	public void declareVariable( Ident ident, Type type ) {
		this.types.put( ident, type );
	}
}
