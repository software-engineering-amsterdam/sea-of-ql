package org.uva.sea.ql.ast.stmnt;

import java.util.List;

public class Body extends Statement {
	
	private List<Statement> statements;
	
	public Body (List<Statement> statements) {
		this.statements=statements;
	}
	
}
