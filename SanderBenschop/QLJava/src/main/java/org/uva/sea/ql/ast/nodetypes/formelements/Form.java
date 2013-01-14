package org.uva.sea.ql.ast.nodetypes.formelements;

import java.util.List;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.ast.nodetypes.primary.Ident;

public class Form implements ASTNode {

	private final Ident identifierName;
	private final List<QLStatement> statements;
	
	public Form(Ident identifierName, List<QLStatement> statements) {
		
		this.identifierName = identifierName;
		this.statements = statements;
	}
	
	public Ident getIdentifier() {
		
		return identifierName;
	}

	public List<QLStatement> getStatements() {
		
		return statements;
	}
}
