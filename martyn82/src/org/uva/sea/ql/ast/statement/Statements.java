package org.uva.sea.ql.ast.statement;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.uva.sea.ql.visitor.StatementVisitor;

public class Statements extends Statement implements Iterable<Statement> {
	private final List<Statement> statements;

	public Statements( Statement statement, Statements statements ) {
		this( statement );
		this.statements.addAll( statements.statements );
	}

	public Statements( Statement statement ) {
		this();
		this.statements.add( statement );
	}

	public Statements() {
		this.statements = new LinkedList<Statement>();
	}

	public int size() {
		return this.statements.size();
	}

	@Override
	public <T> T accept( StatementVisitor<T> visitor ) {
		return visitor.visit( this );
	}

	@Override
	public Iterator<Statement> iterator() {
		return this.statements.iterator();
	}
}
