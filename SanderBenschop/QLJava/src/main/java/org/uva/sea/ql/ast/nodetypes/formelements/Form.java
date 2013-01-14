package org.uva.sea.ql.ast.nodetypes.formelements;

import java.util.List;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.QLStatement;

public class Form implements ASTNode {

	private final List<QLStatement> statements;
	
	public Form(List<QLStatement> statements) {
		this.statements = statements;
	}

	public List<QLStatement> getStatements() {
		return statements;
	}
}
