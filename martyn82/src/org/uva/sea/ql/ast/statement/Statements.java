package org.uva.sea.ql.ast.statement;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.uva.sea.ql.ast.INode;
import org.uva.sea.ql.eval.Context;
import org.uva.sea.ql.eval.value.Value;
import org.uva.sea.ql.visitor.INodeVisitor;

/**
 * Represents a collection of statements.
 */
public class Statements implements INode, Iterable<Statement> {
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
		this.statements = new LinkedList<Statement>();
		this.statements.add( statement );
	}

	@Override
	public Iterator<Statement> iterator() {
		return this.statements.iterator();
	}

	@Override
	public Value<?> accept( INodeVisitor visitor, Context context ) {
		for ( Statement statement : this.statements ) {
			statement.accept( visitor, context );
		}

		return null;
	}
}
