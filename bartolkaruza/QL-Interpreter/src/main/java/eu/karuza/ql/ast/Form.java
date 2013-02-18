package eu.karuza.ql.ast;

import java.util.List;

import eu.karuza.ql.visitor.StatementVisitor;

public class Form implements ASTNode {

	private static final long serialVersionUID = 2334451266044770811L;
	private String label;
	private List<Statement> statements;

	public Form(String label, List<Statement> statements) {
		this.setLabel(label);
		this.statements = statements;
	}

	public void accept(StatementVisitor<?> visitor) {
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
