package org.uva.sea.ql.evaluate;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.type.Type;

/**
 * Represents an evaluation context.
 */
public class Context {
	/**
	 * Holds the parent context.
	 */
	private final Context parent;

	/**
	 * Holds the declared variables.
	 */
	private final Map<Ident, Value> variables;

	/**
	 * Holds the variable types.
	 */
	private final Map<Ident, Type> types;

	/**
	 * Holds the error list.
	 */
	private final List<String> errors;

	/**
	 * Constructs a new context.
	 *
	 * @param parent
	 */
	public Context( Context parent ) {
		this.parent = parent;
		this.variables = new HashMap<Ident, Value>();
		this.types = new HashMap<Ident, Type>();
		this.errors = new LinkedList<String>();
	}

	/**
	 * Constructs a new root context.
	 */
	public Context() {
		this( null );
	}

	/**
	 * Determines whether this context is the root.
	 *
	 * @return True if it is root, false otherwise.
	 */
	public boolean isRoot() {
		return this.parent == null;
	}

	/**
	 * Retrieves the parent context.
	 *
	 * @return The parent.
	 */
	public Context getParent() {
		return this.parent;
	}

	/**
	 * Retrieves the error list.
	 *
	 * @return Errors
	 */
	public List<String> getErrors() {
		return this.errors;
	}

	/**
	 * Adds an error to the list of errors.
	 *
	 * @param message
	 */
	public void addError( String message ) {
		this.errors.add( message );
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

		if ( !this.isRoot() ) {
			return this.parent.isDeclared( ident );
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
	public Value find( Ident ident ) {
		if ( this.variables.containsKey( ident ) ) {
			return this.variables.get( ident );
		}

		if ( !this.isRoot() ) {
			return this.parent.find( ident );
		}

		throw new RuntimeException( "Undefined variable: " + ident.getName() );
	}

	/**
	 * Finds the type of a given identifier.
	 *
	 * @param ident
	 *
	 * @return The type of the variable.
	 *
	 * @throws RuntimeException If the variable cannot be found.
	 */
	public Type findType( Ident ident ) {
		if ( this.types.containsKey( ident ) ) {
			return this.types.get( ident );
		}

		if ( !this.isRoot() ) {
			return this.parent.findType( ident );
		}

		throw new RuntimeException( "Undefined variable: " + ident.getName() );
	}

	/**
	 * Declares a variable for the given identifier and value.
	 *
	 * @param ident
	 * @param value
	 */
	public void declareVariable( Ident ident, Value value ) {
		this.variables.put( ident, value );
	}

	/**
	 * Declares a variable for the given identifier and type.
	 *
	 * @param ident
	 * @param type
	 */
	public void declareType( Ident ident, Type type ) {
		this.types.put( ident, type );
	}
}
