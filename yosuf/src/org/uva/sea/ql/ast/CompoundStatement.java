package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.List;

public class CompoundStatement implements ASTNode {

	List<Statement> statements = new ArrayList<Statement>();

	public CompoundStatement(final Statement statement) {
		statements.add(statement);
	}

	public CompoundStatement(final CompoundStatement compoundStatement,
			final Statement statement) {
		// TODO compoundStatement
		statements.add(statement);
	}
}
