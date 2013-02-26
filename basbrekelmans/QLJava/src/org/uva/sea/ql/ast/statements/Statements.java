package org.uva.sea.ql.ast.statements;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.visitor.IStatementVisitor;

public class Statements extends Statement implements Iterable<Statement> {

	private final List<Statement> children;

	public Statements(final ICodeLocationInformation info,
			final Statement statement) {
		super(info);
		this.children = new LinkedList<Statement>();
		this.children.add(statement);
	}

	public Statements(final ICodeLocationInformation info,
			final Statement statement, final Statements statements) {
		this(info, statement);
		this.children.addAll(statements.children);
	}

	@Override
	public void accept(final IStatementVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Iterator<Statement> iterator() {
		return this.children.iterator();
	}
}
