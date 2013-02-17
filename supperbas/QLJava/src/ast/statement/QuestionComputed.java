package ast.statement;

import ast.statement.Assignment;
import ast.expression.value.Ident;
import ast.expression.value.Str;
import ast.visitor.Visitor;

public class QuestionComputed extends Question {

	private final Assignment assignment;

	public QuestionComputed(Str label, Assignment assignment) {
		super(label);
		this.assignment = assignment;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Ident getIdent() {
		return this.assignment.getIdent();
	}

}
