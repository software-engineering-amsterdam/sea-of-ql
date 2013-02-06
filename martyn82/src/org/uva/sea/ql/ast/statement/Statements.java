package org.uva.sea.ql.ast.statement;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.uva.sea.ql.visitor.StatementVisitor;

/**
 * Represents a collection of statements.
 */
public class Statements extends Statement implements Iterable<Statement> {
	/**
	 * Holds the list of statements.
	 */
	private final List<Statement> statements;

	/**
	 * Constructs a new collection of statements.
	 *
	 * @param statement
	 * @param statements
	 */
	public Statements( Statement statement, Statements statements ) {
		this( statement );
		this.statements.addAll( statements.statements );
	}

	/**
	 * Constructs a new collection of statements.
	 *
	 * @param statement
	 */
	public Statements( Statement statement ) {
		this();
		this.statements.add( statement );
	}

	/**
	 * Constructs an empty Statements instance.
	 */
	public Statements() {
		this.statements = new LinkedList<Statement>();
	}

	/**
	 * Retrieves the number of statements in this collection.
	 *
	 * @return The number of statements.
	 */
	public int size() {
		return this.statements.size();
	}

	/**
	 * Retrieves the first statement of the list.
	 *
	 * @return The first statement, or null if it does not exist.
	 */
	public Statement getFirst() {
		if ( size() < 1 ) {
			return null;
		}

		return this.statements.get( 0 );
	}

	/**
	 * Accept a visitor.
	 *
	 * @param visitor
	 */
	@Override
	public <T> T accept( StatementVisitor<T> visitor ) {
		return visitor.visit( this );
	}

	@Override
	public Iterator<Statement> iterator() {
		return this.statements.iterator();
	}
}
