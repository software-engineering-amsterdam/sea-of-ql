package org.uva.sea.ql.ast;

import java.util.List;

import org.uva.sea.ql.ast.stmt.Statement;
import org.uva.sea.ql.visitor.Visitor;

public class Form implements ASTNode {

	private final String id;
	private List<Statement> statements;
	
	public Form(String id, List<Statement> statements) {
		this.id = id;
		this.setStatements(statements);
	}

	public String getId() {
		return id;
	}

	public List<Statement> getStatements() {
		return statements;
	}

	public void setStatements(List<Statement> statements) {
		this.statements = statements;
	}

	@Override
	public void accept(Visitor visitor) {
		for(ASTNode node : statements) {
            node.accept(visitor);
        }
        visitor.visit(this);	
	}
}
