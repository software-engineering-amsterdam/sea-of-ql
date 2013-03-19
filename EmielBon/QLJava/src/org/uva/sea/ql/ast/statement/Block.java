package org.uva.sea.ql.ast.statement;

import java.util.ArrayList;
import java.util.List;

public class Block extends Statement {

	private final List<Statement> statements = new ArrayList<Statement>();
	
	public Block(Statement statement) {
		statements.add(statement);
	}
	
	public Block(Statement statement, Block statements) {
		this.statements.add(statement);
		this.statements.addAll(statements.statements);
	}
	
	public List<Statement> getBody() {
		return statements;
	}

	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}

}