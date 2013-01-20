package org.uva.sea.ql.ast.statement;

import java.util.List;

public class Block extends AbstractStatement {

	private final List<AbstractStatement> statements;

	public Block(List<AbstractStatement> statements) {
		this.statements = statements;
	}

	public List<AbstractStatement> getStatements() {
		return this.statements;
	}

}
