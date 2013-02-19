package org.uva.sea.ql.ast;

import java.util.List;

import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.stmt.Statement;
import org.uva.sea.ql.visitor.IFormVisitor;

public class Form implements ASTNode {
	private final Ident id;
	private List<Statement> statements;
	
	public Form(Ident id, List<Statement> statements) {
		this.id = id;
		this.setStatements(statements);
	}

	public Ident getId() {
		return id;
	}

	public List<Statement> getStatements() {
		return statements;
	}

	public void setStatements(List<Statement> statements) {
		this.statements = statements;
	}

	@Override
	public void accept(IFormVisitor visitor) {	
		visitor.visit(this);	
	}
}
