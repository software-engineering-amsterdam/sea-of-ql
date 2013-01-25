package org.uva.sea.ql.ast.statements;

import java.util.ArrayList;

public class BlockOfStatements extends Statement {
	private final ArrayList<Statement> blStms = new ArrayList<Statement>();
	
	public void addStatement(Statement stm) {
		blStms.add(stm);
	}
}