package org.uva.sea.ql.ast.statement;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Represents a collection of statements.
 */
public class Statements extends Node implements Iterable<Statement> {
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

	public Statements() {
		this.statements = new LinkedList<Statement>();
	}

	@Override
	public Iterator<Statement> iterator() {
		return this.statements.iterator();
	}

	@Override
	public <T> T accept( NodeVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
