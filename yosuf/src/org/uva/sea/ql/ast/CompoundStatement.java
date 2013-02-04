package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.List;

import org.jpatterns.gof.CompositePattern.Composite;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

@Composite
public class CompoundStatement extends Statement {

	private final List<Statement> statements = new ArrayList<Statement>();

	public CompoundStatement(final Statement statement) {
		statements.add(statement);
	}

	public CompoundStatement(final CompoundStatement compoundStatement,
			final Statement statement) {
		statements.addAll(compoundStatement.statements);
		statements.add(statement);
	}

	@Override
	public void accept(final ASTNodeVisitor visitor) {
		visitor.visit(this);
	}

	public List<Statement> getStatements() {
		return new ArrayList<Statement>(statements);
	}
}
