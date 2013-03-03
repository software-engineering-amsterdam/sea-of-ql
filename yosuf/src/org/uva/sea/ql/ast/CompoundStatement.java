package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.List;

import org.jpatterns.gof.CompositePattern.Composite;

@Composite
public class CompoundStatement extends Block {

	private final List<Block> statements = new ArrayList<Block>();

	public CompoundStatement(final Block statement) {
		statements.add(statement);
	}

	public CompoundStatement(final CompoundStatement compoundStatement, final Block statement) {
		statements.addAll(compoundStatement.statements);
		statements.add(statement);
	}

	public List<Block> getStatements() {
		return new ArrayList<Block>(statements);
	}

	@Override
	public <T> T accept(final StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "CompoundStatement [statements=" + statements + "]";
	}

}
