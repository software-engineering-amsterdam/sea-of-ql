package org.uva.sea.ql.ast;

import java.util.List;

public class Block extends Statement {
	
	private List<Statement> statements;
	
	public Block(List<Statement> statements) {
		this.statements = statements;
	}

}
