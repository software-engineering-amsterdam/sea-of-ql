package org.uva.sea.ql.validation;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.types.Type;

public class Registry {
	private List<Question> questions;
	private List<IfStatement> ifStatements;

	public Registry() {
		this.questions = new ArrayList<Question>();
		this.ifStatements = new ArrayList<IfStatement>();
	}

	public void addQuestion(Question q) {
		this.questions.add(q);
	}

	public void addIfStatement(IfStatement i) {
		this.ifStatements.add(i);
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	public List<IfStatement> getIfStatements() {
		return this.ifStatements;
	}

	public Type getQuestionTypeByIdent(Ident i) {
		for (Question q : questions) {
			if (q.getIdentName().equals(i.getName())) {
				return q.getType();
			}
		}
		return null;
	}
}
