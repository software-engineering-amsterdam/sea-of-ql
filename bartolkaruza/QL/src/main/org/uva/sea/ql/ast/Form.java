package org.uva.sea.ql.ast;

import java.util.List;

import org.uva.sea.ql.visitor.StatementVisitor;

public class Form implements ASTNode {

	private String label;
	private List<Statement> statements;

	public Form(String label, List<Statement> statements) {
		this.setLabel(label);
		this.statements = statements;
	}

	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Statement> getStatements() {
		return statements;
	}

}
